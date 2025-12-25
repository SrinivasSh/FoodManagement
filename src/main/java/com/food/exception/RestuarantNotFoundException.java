package com.food.exception;

public class RestuarantNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestuarantNotFoundException(String message) {
		super(message);
	}
	

}
