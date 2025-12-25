package com.food.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.Model.Restuarant;

public interface RestuarantRepository extends JpaRepository<Restuarant, Integer> {
	
	Optional<Restuarant> findByrestuarantName(String resturantName);

}
