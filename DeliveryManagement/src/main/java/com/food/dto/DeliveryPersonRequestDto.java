package com.food.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPersonRequestDto {

	private String deliveryPersonName;

	private String phoneNumber;

	private String email;

	private List<DeliveryAssignmentRequestDto> deliveryAssignmentRequestDto;

}
