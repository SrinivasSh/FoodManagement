package com.food.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.food.builder.OrderRequestBuilder;
import com.food.builder.OrderResponseDtoBuilder;
import com.food.dao.OrderRepository;
import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;
import com.food.exception.OrderNotFoundException;
import com.food.exception.RestaurantNotFoundException;
import com.food.model.Order;
import com.food.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;

	public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
		this.orderRepository = orderRepository;
		this.restTemplate = restTemplate;
	}

	// Using rest Template for fetching restuarantName
	public String fetchResturantName(Order order) {
		return restTemplate.getForObject("http://RestaurantManagement/restuarant/getName/" + order.getResturantId(),
				String.class);

	}

	@Override
	public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
		Order order = OrderRequestBuilder.buildOrderFromOrderRequestDto(orderRequestDto);
		Order saveOrder = orderRepository.save(order);
		OrderResponseDto orderResponseDto = OrderResponseDtoBuilder.buildOrderResponseDtoFromOrder(saveOrder);
		String resturantName = fetchResturantName(order);
		orderResponseDto.setResturantName(resturantName);
		return orderResponseDto;
	}

	@Override
	public OrderResponseDto updateOrderStatus(int orderId, String status) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order Not Found with Id :" + orderId));
		order.setStatus(status);
		orderRepository.save(order);
		OrderResponseDto orderResponseDto = OrderResponseDtoBuilder.buildOrderResponseDtoFromOrder(order);
		String resturantName = fetchResturantName(order);
		orderResponseDto.setResturantName(resturantName);
		return orderResponseDto;
	}

	@Override
	public List<OrderResponseDto> fetchAllOrders() {
		return orderRepository.findAll().stream().map(OrderResponseDtoBuilder::buildOrderResponseDtoFromOrder)
				.collect(Collectors.toList());
	}
	
	
	@Override
	@CircuitBreaker(name = "orderManagementCB", fallbackMethod = "fallBackForRestuarantName")
	public String getRestuarantName(int restuarantId) {

		return restTemplate.getForObject("http://RestaurantManagement/restuarant/getName/" + restuarantId,
				String.class);


	}
	
	public String fallBackForRestuarantName(int restuarantId, Throwable throwable) {
		return "Restaurant Service is currently unavailable. Please try again later." ;
		
	}

}
