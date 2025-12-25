package com.food.builder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.food.Model.Address;
import com.food.Model.Item;
import com.food.Model.Restuarant;
import com.food.dto.AddressRequestDto;
import com.food.dto.ItemRequestDto;
import com.food.dto.RestuarantRequestDto;

public class RestuarantRequestBuilder {

	public static Restuarant buildRestuarantFromResturantDtO(RestuarantRequestDto restuarantRequestDto) {
		return Restuarant.builder()
				.restuarantName(restuarantRequestDto.getRestuarantName())
				.phoneNumber(restuarantRequestDto.getPhoneNumber())
				.address(buildAddressFromAddressDto(restuarantRequestDto.getAddressRequestDto()))
				.items(buildItemFromItemsDto(restuarantRequestDto.getItemRequestDto()))
				.build();

	}

	public static Address buildAddressFromAddressDto(AddressRequestDto addressRequestDto) {
		Address address = new Address();
		BeanUtils.copyProperties(addressRequestDto, address);
		return address;
	}

	public static List<Item> buildItemFromItemsDto(List<ItemRequestDto> itemsRequestDto) {
		List<Item> items = new ArrayList<Item>();
		for (ItemRequestDto itemsRequestDtos : itemsRequestDto) {
			Item item = new Item();
			BeanUtils.copyProperties(itemsRequestDtos, item);
			items.add(item);

		}
		return items;
	}

}
