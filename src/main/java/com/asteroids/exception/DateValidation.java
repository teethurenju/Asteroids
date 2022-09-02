package com.asteroids.exception;

public class DateValidation extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DateValidation(String message) {
		super(message);
		this.message = message;
	}
	
	public DateValidation() {
		
	}
}
