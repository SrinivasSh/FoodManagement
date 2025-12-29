package com.food.fiegnClients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "RestaurantManagement")
public interface OrderClient {

}
