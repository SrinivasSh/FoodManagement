package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {

	private String landMark;

	private String city;

	private String pinCode;

	private String district;

	private String state;

}
