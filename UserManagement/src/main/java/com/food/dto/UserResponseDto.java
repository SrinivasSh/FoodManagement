package com.food.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

	private int userId;

	private String userName;

	private String phoneNumber;

	private String email;

	private String password;

	private List<UserAddressResponseDto> userAddressResponseDto;

}
