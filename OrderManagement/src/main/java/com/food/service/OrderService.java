package com.food.service;

import java.util.List;

import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;

public interface OrderService {

	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

	public OrderResponseDto updateOrderStatus(int orderId, String status);

	public List<OrderResponseDto> fetchAllOrders();

	public String getRestuarantName(int restuarantId);

}
