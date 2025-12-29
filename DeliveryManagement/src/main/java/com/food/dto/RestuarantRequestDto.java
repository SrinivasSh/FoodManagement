package com.food.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestuarantRequestDto {

	private String restuarantName;

	private String phoneNumber;

	private AddressRequestDto addressRequestDto;

	private List<ItemRequestDto> itemRequestDto;

}
