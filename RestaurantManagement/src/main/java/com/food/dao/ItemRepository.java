package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
