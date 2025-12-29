package com.food.fiegnClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;

@FeignClient(name = "RestaurantManagement")
public interface RestuarantClient {

	@GetMapping("/restuarant/getAll")
	public ResponseEntity<List<RestuarantResponseDto>> getAllResturants();

	@PostMapping("/restuarant/add")
	public ResponseEntity<RestuarantCreationResponse> addResturant(
			@RequestBody RestuarantRequestDto restuarantRequestDto);

}
