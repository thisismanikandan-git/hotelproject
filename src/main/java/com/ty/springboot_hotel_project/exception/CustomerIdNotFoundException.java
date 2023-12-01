package com.ty.springboot_hotel_project.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	private String message = "Customer Id Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public CustomerIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CustomerIdNotFoundException() {
		super();
	}

}
