package com.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.DeliveryPerson;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Integer>{

}
