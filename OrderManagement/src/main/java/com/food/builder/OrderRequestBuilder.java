package com.food.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.food.dto.OrderItemRequestDto;
import com.food.dto.OrderRequestDto;
import com.food.model.Order;
import com.food.model.OrderItem;

public class OrderRequestBuilder {

	public static Order buildOrderFromOrderRequestDto(OrderRequestDto orderRequestDto) {
		return Order.builder()
				.status("Ordered")
				.orderPrice(orderRequestDto.getOrderPrice())
				.resturantId(orderRequestDto.getResturantId())
				.userId(orderRequestDto.getUserId())
				.orderItem(buildOrderItemFromOrderItemRequest(orderRequestDto.getOrderItemRequestDto()))
				.build();
	}

	private static List<OrderItem> buildOrderItemFromOrderItemRequest(List<OrderItemRequestDto> orderItemRequestList) {
		List<OrderItem> orderItemList = new ArrayList<>();
		for (OrderItemRequestDto orderItems : orderItemRequestList) {
			OrderItem orderItem = new OrderItem();
			BeanUtils.copyProperties(orderItems, orderItem);
			orderItemList.add(orderItem);

		}
		return orderItemList;

	}

}
