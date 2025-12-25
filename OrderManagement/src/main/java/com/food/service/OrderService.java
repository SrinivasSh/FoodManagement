package com.food.service;

import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;

public interface OrderService {

	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

	public OrderResponseDto updateOrderStatus(int orderId, String status);

}
