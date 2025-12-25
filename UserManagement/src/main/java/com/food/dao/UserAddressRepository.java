package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

}
