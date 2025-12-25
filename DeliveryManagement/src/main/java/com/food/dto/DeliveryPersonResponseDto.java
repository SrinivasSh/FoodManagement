package com.food.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPersonResponseDto {

	private int deliveryPersonId;

	private String deliveryPersonName;

	private String phoneNumber;

	private String email;

	private boolean isAvailable;

	private double rating;

	private List<DeliveryAssignmentResponseDto> deliveryAssignmentResponseDtoList;

}
