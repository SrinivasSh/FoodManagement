package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressRequestDto {

	private String street;

	private String city;

	private String landMark;

	private String district;
	
	private String state;

	private String pincode;

}
