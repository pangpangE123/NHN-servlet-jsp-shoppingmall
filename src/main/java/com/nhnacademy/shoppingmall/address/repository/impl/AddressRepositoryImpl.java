package com.nhnacademy.shoppingmall.address.repository.impl;

import com.nhnacademy.shoppingmall.address.domain.Address;
import com.nhnacademy.shoppingmall.address.repository.AddressRepository;
import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.user.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class AddressRepositoryImpl implements AddressRepository {
    @Override
    public Optional<List<Address>> findByUserId(String userId) {

        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "select * from address where user_id=?";
        log.debug("sql:{}", sql);

        try (
                PreparedStatement psmt = connection.prepareStatement(sql);
        ) {

            List<Address> addresses = new ArrayList<>();
            psmt.setString(1, userId);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                Address address = new Address(
                        rs.getLong("address_id"),
                        rs.getString("address"),
                        rs.getString("user_id")
                );

                addresses.add(address);
            }

            return Optional.of(addresses);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int save(Address address) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "insert into address(address, user_id) values(?,?)";
        log.debug("sql:{}", sql);

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {

            psmt.setString(1, address.getAddress());
            psmt.setString(2,address.getUserId());

            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Long addressId) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "delete from address where address_id=?";
        log.debug("sql:{}", sql);

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {

            psmt.setLong(1, addressId);

            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
