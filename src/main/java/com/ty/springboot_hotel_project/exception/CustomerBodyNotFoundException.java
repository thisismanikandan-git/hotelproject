package com.ty.springboot_hotel_project.exception;

public class CustomerBodyNotFoundException extends RuntimeException {

	private String message = "Customer Body Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public CustomerBodyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerBodyNotFoundException() {
		super();
	}

}
