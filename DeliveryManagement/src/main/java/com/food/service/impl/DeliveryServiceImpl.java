package com.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.dao.DeliveryPersonRepository;
import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;
import com.food.fiegnClients.RestuarantClient;
import com.food.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	private final DeliveryPersonRepository deliveryPersonRepository;

	private final RestTemplate restTemplate;

	@Autowired
	private RestuarantClient restuarantClinet;

	public DeliveryServiceImpl(DeliveryPersonRepository deliveryPersonRepository, RestTemplate restTemplate) {
		this.deliveryPersonRepository = deliveryPersonRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public ResponseEntity<OrderResponseDto> updateOrderStatus(int orderId, String status) {
		ResponseEntity<OrderResponseDto> orderResponseEntity = restTemplate.exchange(
				"http://localhost:8001/orders/status/" + orderId + "?status=" + status, HttpMethod.PUT, null,
				OrderResponseDto.class);
		return orderResponseEntity;
	}

	@Override
	public ResponseEntity<List<RestuarantResponseDto>> getAllResturants() {
		return restuarantClinet.getAllResturants();
	}

	@Override
	public ResponseEntity<RestuarantCreationResponse> addResturant(RestuarantRequestDto restuarantRequestDto) {
		return restuarantClinet.addResturant(restuarantRequestDto);
	}

}
