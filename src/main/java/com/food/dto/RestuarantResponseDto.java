package com.food.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestuarantResponseDto {

	private int restuarantId;

	private String restuarantName;

	private String phoneNumber;

	private double restuarantRating;

	private AddressResponseDto addressResponseDto;

	private List<ItemResponseDto> itemResponseDto;
}
