package com.food.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.food.Model.Restuarant;
import com.food.builder.RestuarantRequestBuilder;
import com.food.builder.RestuarantResponseDtoBuilder;
import com.food.dao.RestuarantRepository;
import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;
import com.food.exception.RestuarantNotFoundException;
import com.food.service.RestuarantService;

@Service
public class RestuarantServiceImpl implements RestuarantService {

	private final RestuarantRepository restuarantRepository;
	
	private final RestTemplate restTemplate;

	public RestuarantServiceImpl(RestuarantRepository restuarantRepository, RestTemplate restTemplate) {
		this.restuarantRepository = restuarantRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public RestuarantCreationResponse addRestuarant(RestuarantRequestDto restuarantRequestDto) {
		Restuarant restuarant = RestuarantRequestBuilder.buildRestuarantFromResturantDtO(restuarantRequestDto);

		Restuarant addRestuarant = restuarantRepository.save(restuarant);

		return new RestuarantCreationResponse(addRestuarant.getRestaurantId(), addRestuarant.getRestuarantName());

	}

	@Override
	public RestuarantResponseDto getResturantById(int resturantId) {
		Restuarant restuarant = restuarantRepository.findById(resturantId)
				.orElseThrow(() -> new RestuarantNotFoundException("No Restuarant found with this id :" + resturantId));
		return RestuarantResponseDtoBuilder.buildResturantDtoFromRestuarant(restuarant);

	}

	@Override
	public RestuarantResponseDto getRestuarantByName(String resturantName) {
		Restuarant restuarant = restuarantRepository.findByrestuarantName(resturantName)
				.orElseThrow(() -> new RestuarantNotFoundException("No Resturant found with this restuarant name :"+ resturantName));
		return RestuarantResponseDtoBuilder.buildResturantDtoFromRestuarant(restuarant);
	}

	@Override
	public List<RestuarantResponseDto> fetchAllRestuarants() {
		return restuarantRepository.findAll().stream()
				.map(RestuarantResponseDtoBuilder::buildResturantDtoFromRestuarant)
				.collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<OrderResponseDto> placeOrder(OrderRequestDto orderRequestDto) {
		return restTemplate.postForEntity("http://localhost:8001/orders", orderRequestDto, OrderResponseDto.class);
	}

}
