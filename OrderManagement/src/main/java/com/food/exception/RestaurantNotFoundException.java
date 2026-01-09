package com.food.exception;

public class RestaurantNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestaurantNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
