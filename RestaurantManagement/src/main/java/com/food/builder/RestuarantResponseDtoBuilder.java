package com.food.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.food.Model.Address;
import com.food.Model.Item;
import com.food.Model.Restuarant;
import com.food.dto.AddressResponseDto;
import com.food.dto.ItemResponseDto;
import com.food.dto.RestuarantResponseDto;

public class RestuarantResponseDtoBuilder {

	public static RestuarantResponseDto buildResturantDtoFromRestuarant(Restuarant restuarant) {
		return RestuarantResponseDto.builder()
				.restuarantId(restuarant.getRestaurantId())
				.restuarantName(restuarant.getRestuarantName())
				.phoneNumber(restuarant.getPhoneNumber())
				.restuarantRating(restuarant.getRestuarantRating())
				.addressResponseDto(buildAddressResponseFromAddress(restuarant.getAddress()))
				.itemResponseDto(buildItemResponseFromItem(restuarant.getItems()))
				.build();

	}
	
	public static AddressResponseDto buildAddressResponseFromAddress(Address address) {
		AddressResponseDto addressResponse = new AddressResponseDto();
		BeanUtils.copyProperties(address, addressResponse);
		return addressResponse;

	}
	
	
	public static List<ItemResponseDto> buildItemResponseFromItem(List<Item> items){
		List<ItemResponseDto> itemResponseList = new ArrayList<>();
		for(Item itemList : items) {
			ItemResponseDto itemResponseDto = new ItemResponseDto();
			BeanUtils.copyProperties(itemList, itemResponseDto);
			itemResponseList.add(itemResponseDto);
			
			
		}
		return itemResponseList;
		
	}

}
