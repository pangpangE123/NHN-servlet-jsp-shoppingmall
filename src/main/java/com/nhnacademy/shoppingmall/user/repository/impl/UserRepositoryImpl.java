package com.nhnacademy.shoppingmall.user.repository.impl;

import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import com.nhnacademy.shoppingmall.user.domain.User;
import com.nhnacademy.shoppingmall.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Optional<User> findByUserIdAndUserPassword(String userId, String userPassword) {
        /*todo#3-1 회원의 아이디와 비밀번호를 이용해서 조회하는 코드 입니다.(로그인)
          해당 코드는 SQL Injection이 발생합니다. SQL Injection이 발생하지 않도록 수정하세요.
         */

        Connection connection = DbConnectionThreadLocal.getConnection();

        String sql = "select user_id, user_name, user_password, user_birth, user_auth, user_point, created_at, latest_login_at from users where user_id=? and user_password =?";
//        String sql =String.format("select user_id, user_name, user_password, user_birth, user_auth, user_point, created_at, latest_login_at from users where user_id='%s' and user_password ='%s'",
//                userId,
//                userPassword
//        );

        log.debug("sql:{}", sql);

        try (
                PreparedStatement psmt = connection.prepareStatement(sql);
//                Statement psmt = connection.createStatement();
        ) {

            psmt.setString(1, userId);
            psmt.setString(2, userPassword);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("user_birth"),
                        User.Auth.valueOf(rs.getString("user_auth")),
                        rs.getInt("user_point"),
                        Objects.nonNull(rs.getTimestamp("created_at")) ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                        Objects.nonNull(rs.getTimestamp("latest_login_at")) ? rs.getTimestamp("latest_login_at").toLocalDateTime() : null
                );
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String userId) {
        //todo#3-2 회원조회
        Connection connection = DbConnectionThreadLocal.getConnection();

        String sql = "select * from users where user_id=?";

        log.debug("sql:{}", sql);

        try (
                PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                User user = new User(
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getString("user_birth"),
                        User.Auth.valueOf(rs.getString("user_auth")),
                        rs.getInt("user_point"),
                        Objects.nonNull(rs.getTimestamp("created_at")) ? rs.getTimestamp("created_at").toLocalDateTime() : null,
                        Objects.nonNull(rs.getTimestamp("latest_login_at")) ? rs.getTimestamp("latest_login_at").toLocalDateTime() : null
                );
                return Optional.of(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public int save(User user) {
        //todo#3-3 회원등록, executeUpdate()을 반환합니다.
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "insert into users(user_id, user_name, user_password, user_birth, user_auth, user_point, created_at, latest_login_at) values (?, ?, ?, ?, ? ,? ,?, ?)";


        try (PreparedStatement psmt = connection.prepareStatement(sql)) {

            psmt.setString(1, user.getUserId());
            psmt.setString(2, user.getUserName());
            psmt.setString(3, user.getUserPassword());
            psmt.setString(4, user.getUserBirth());
            psmt.setString(5,user.getUserAuth().toString());
            psmt.setInt(6, user.getUserPoint());


            if(Objects.nonNull(user.getCreatedAt())){
                psmt.setString(7,user.getCreatedAt().format(TIME_FORMATTER));
                log.debug("----------------:{}",user.getCreatedAt().format(TIME_FORMATTER));
            }
            else{
                psmt.setString(7,LocalDateTime.now().format(TIME_FORMATTER));
            }

            if(Objects.nonNull(user.getLatestLoginAt())){
                psmt.setString(8,user.getLatestLoginAt().format(TIME_FORMATTER));
            }
            else{
                psmt.setNull(8,Types.VARCHAR);
            }


            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteByUserId(String userId) {
        //todo#3-4 회원삭제, executeUpdate()을 반환합니다.
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "delete from users where user_id=?";

        try (PreparedStatement psmt = connection.prepareStatement(sql)) {
            psmt.setString(1, userId);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        //todo#3-5 회원수정, executeUpdate()을 반환합니다.
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "update users set user_name=?, user_password=?, user_birth=?, user_auth=?,  user_point=?, created_at=?, latest_login_at=? where user_id=?";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
        ){

            psmt.setString(1, user.getUserName());
            psmt.setString(2, user.getUserPassword());
            psmt.setString(3, user.getUserBirth());
            psmt.setString(4,user.getUserAuth().toString());
            psmt.setInt(5, user.getUserPoint());


            if(Objects.nonNull(user.getCreatedAt())){
                psmt.setString(6,user.getCreatedAt().format(TIME_FORMATTER));
                log.debug("----------------:{}",user.getCreatedAt().format(TIME_FORMATTER));
            }
            else{
                psmt.setString(6,LocalDateTime.now().format(TIME_FORMATTER));
            }

            if(Objects.nonNull(user.getLatestLoginAt())){
                psmt.setString(7,user.getLatestLoginAt().format(TIME_FORMATTER));
            }
            else{
                psmt.setNull(7,Types.VARCHAR);
            }

            psmt.setString(8, user.getUserId());


            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int updateLatestLoginAtByUserId(String userId, LocalDateTime latestLoginAt) {
        //todo#3-6, 마지막 로그인 시간 업데이트, executeUpdate()을 반환합니다.
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "update users set latest_login_at=? where user_id=?";
        try (PreparedStatement psmt = connection.prepareStatement(sql);
        ){


            psmt.setString(2,userId);
            psmt.setString(1,latestLoginAt.format(TIME_FORMATTER));
            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countByUserId(String userId) {
        //todo#3-7 userId와 일치하는 회원의 count를 반환합니다.
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "select COUNT(*) as cnt from users where user_id=?";

        try (PreparedStatement psmt = connection.prepareStatement(sql);
        ){
            psmt.setString(1, userId);

            ResultSet rs = psmt.executeQuery();
            rs.next();
            return rs.getInt("cnt");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

