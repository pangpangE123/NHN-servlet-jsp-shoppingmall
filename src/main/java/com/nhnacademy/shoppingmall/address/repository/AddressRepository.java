package com.nhnacademy.shoppingmall.address.repository;

import com.nhnacademy.shoppingmall.address.domain.Address;
import com.nhnacademy.shoppingmall.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {

    Optional<List<Address>> findByUserId(String userId);
    int save(Address address);
    int delete(Long addressId );

}
