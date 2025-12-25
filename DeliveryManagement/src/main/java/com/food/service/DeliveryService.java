package com.food.service;

import org.springframework.http.ResponseEntity;

import com.food.dto.OrderResponseDto;

public interface DeliveryService {

	ResponseEntity<OrderResponseDto> updateOrderStatus(int orderId, String status);

}
