package com.food.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;

public interface DeliveryService {

	ResponseEntity<OrderResponseDto> updateOrderStatus(int orderId, String status);
	
	ResponseEntity<List<RestuarantResponseDto>> getAllResturants();

	ResponseEntity<RestuarantCreationResponse> addResturant(RestuarantRequestDto restuarantRequestDto);

}