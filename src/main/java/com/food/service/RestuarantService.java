package com.food.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;

public interface RestuarantService {

	public RestuarantCreationResponse addRestuarant(RestuarantRequestDto restuarantRequestDto);

	public RestuarantResponseDto getResturantById(int resturantId);
	
	public RestuarantResponseDto getRestuarantByName(String resturantName);

	public List<RestuarantResponseDto> fetchAllRestuarants();

	public ResponseEntity<OrderResponseDto> placeOrder(OrderRequestDto orderRequestDto);

}
