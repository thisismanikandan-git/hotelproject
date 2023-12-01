package com.ty.springboot_hotel_project.exception;

public class CustomerEmailNotFoundException extends RuntimeException {

	private String message = "Customer Email Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerEmailNotFoundException() {
		super();
	}

}
