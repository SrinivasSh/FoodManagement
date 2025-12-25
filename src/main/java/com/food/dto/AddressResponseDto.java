package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {

	private int addressId;

	private String landMark;

	private String city;

	private String pinCode;

	private String district;

	private String state;

}
