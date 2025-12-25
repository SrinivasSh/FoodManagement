package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
