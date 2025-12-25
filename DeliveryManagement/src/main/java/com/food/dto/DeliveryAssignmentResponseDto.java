package com.food.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAssignmentResponseDto {
	
	private long deliveryAssignmentId;
	
    private String status;
    
    private LocalTime assignedTime;
    
    private int orderId;
    
    private int deliveryPersonId;
    
    private String deliveryPersonName;
	

}
