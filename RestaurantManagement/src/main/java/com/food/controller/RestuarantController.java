package com.food.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;
import com.food.service.RestuarantService;

@RestController
@RequestMapping("/restuarant")
public class RestuarantController {

	private final RestuarantService restuarantService;

	public RestuarantController(RestuarantService restuarantService) {
		this.restuarantService = restuarantService;
	}

	@PostMapping("/add")
	public ResponseEntity<RestuarantCreationResponse> addResturant(
			@RequestBody RestuarantRequestDto restuarantRequestDto) {
		RestuarantCreationResponse resturantCreationResponse = restuarantService.addRestuarant(restuarantRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(resturantCreationResponse);

	}

	@GetMapping("/{resturantId}")
	public ResponseEntity<RestuarantResponseDto> getResturant(@PathVariable(name = "resturantId") int resturantId) {
		RestuarantResponseDto restuarantResponseDto = restuarantService.getResturantById(resturantId);
		return ResponseEntity.ok(restuarantResponseDto);

	}

	// Get restuarant details by name
	@GetMapping("/name/{resturantName}")
	public ResponseEntity<RestuarantResponseDto> getResturantByName(
			@PathVariable(name = "resturantName") String resturantName) {
		RestuarantResponseDto restuarantResponseDto = restuarantService.getRestuarantByName(resturantName);
		return ResponseEntity.ok(restuarantResponseDto);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<RestuarantResponseDto>> getAllResturants() {
		List<RestuarantResponseDto> restuarantResponseDto = restuarantService.fetchAllRestuarants();
		return ResponseEntity.ok(restuarantResponseDto);

	}

	@GetMapping("/getName/{resturantId}")
	public ResponseEntity<String> getResturantNameByID(@PathVariable(name = "resturantId") int resturantId) {
		RestuarantResponseDto restuarantResponseDto = restuarantService.getResturantById(resturantId);
		return ResponseEntity.ok(restuarantResponseDto.getRestuarantName());
	}
	
	//PLACE ORDER FROM RESTUARANT
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
		return restuarantService.placeOrder(orderRequestDto);
	
		
	}

}
