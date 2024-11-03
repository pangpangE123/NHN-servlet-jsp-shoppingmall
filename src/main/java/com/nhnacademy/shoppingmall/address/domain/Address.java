package com.nhnacademy.shoppingmall.address.domain;

import com.nhnacademy.shoppingmall.user.domain.User;

import java.util.Objects;

public class Address {

    private Long addressId;
    private String address;
    private String userId;

    public Address(Long addressId, String address, String userId) {
        this.addressId = addressId;
        this.address = address;
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public String getUserId() {
        return userId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == ((Address) o).getAddressId()
                && address.equals(((Address) o).getAddress())
                && userId.equals(((Address) o).getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId,address,userId);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                "address='" + address + '\'' +
                "userId='" + userId + '\'' +
                '}';
    }
}
