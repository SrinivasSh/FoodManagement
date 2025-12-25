package com.food.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

	private double orderPrice;

	private int resturantId;

	private int userId;

	private List<OrderItemRequestDto> orderItemRequestDto;

}
