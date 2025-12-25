package com.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

	private int itemId;

	private String itemName;

	private double itemPrice;

	private boolean isAvailable;

	private String itemCategory;

	private String itemType;

	private double itemRating;

}
