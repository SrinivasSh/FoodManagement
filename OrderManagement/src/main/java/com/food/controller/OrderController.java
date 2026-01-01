package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.dto.OrderRequestDto;
import com.food.dto.OrderResponseDto;
import com.food.service.OrderService;

@RestController
@RequestMapping("/orders")
@RefreshScope
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@Value("${discount.food}")
	private int discount;

	@PostMapping
	public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
		OrderResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
	}

	@PutMapping("/status/{orderId}")
	public ResponseEntity<OrderResponseDto> updateOrderStatus(@PathVariable(name = "orderId") int orderId,
			@RequestParam(name = "status") String status) {
		OrderResponseDto orderResponseDto = orderService.updateOrderStatus(orderId, status);
		return ResponseEntity.ok(orderResponseDto);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
		List<OrderResponseDto> orderResponseDto = orderService.fetchAllOrders();
		return ResponseEntity.ok(orderResponseDto);

	}

	// GET DISCOUNT FROM PROPERTIES FILES
	@GetMapping("/discount")
	public int discount() {
		return discount;
	}

}
