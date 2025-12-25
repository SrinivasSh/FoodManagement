package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestuarantCreationResponse {
	
	private int resturantId;
	
	private String restuarantName;

}
