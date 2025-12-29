package com.food.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.OrderResponseDto;
import com.food.dto.RestuarantCreationResponse;
import com.food.dto.RestuarantRequestDto;
import com.food.dto.RestuarantResponseDto;
import com.food.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryPersonController {

	private final DeliveryService deliveryService;

	public DeliveryPersonController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@PutMapping("/orderStatus/{orderId}")
	public ResponseEntity<OrderResponseDto> updateOrderStatus(@PathVariable(name = "orderId") int orderId,
			@RequestParam(name = "status") String status) {
		return deliveryService.updateOrderStatus(orderId, status);

	}

	// Retrieve all restuarants
	@GetMapping("/getAllRestuarants")
	public ResponseEntity<List<RestuarantResponseDto>> getAllResturants() {
		return deliveryService.getAllResturants();
	}

	// Add resturant from delivery using feign client
	@PostMapping("/addResturant")
	public ResponseEntity<RestuarantCreationResponse> addResturant(@RequestBody RestuarantRequestDto restuarantRequestDto) {
		return deliveryService.addResturant(restuarantRequestDto);
	}

}
