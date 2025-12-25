package com.food.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.food.dto.OrderItemResponseDto;
import com.food.dto.OrderResponseDto;
import com.food.model.Order;
import com.food.model.OrderItem;

public class OrderResponseDtoBuilder {

	public static OrderResponseDto buildOrderResponseDtoFromOrder(Order order) {
		return OrderResponseDto.builder()
				.orderId(order.getOrderId())
				.status(order.getStatus())
				.orderPrice(order.getOrderPrice())
				.orderItemResponseDto(buildOrderItemResponseFromOrderItem(order.getOrderItem()))
				.build();

	}

	private static List<OrderItemResponseDto> buildOrderItemResponseFromOrderItem(List<OrderItem> orderItemsList) {
		List<OrderItemResponseDto> orderItemResponseDtoList = new ArrayList<>();
		for (OrderItem orderItems : orderItemsList) {
			OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();
			BeanUtils.copyProperties(orderItems, orderItemResponseDto);
			orderItemResponseDtoList.add(orderItemResponseDto);
		}
		return orderItemResponseDtoList;
	}

}
