package com.ty.springboot_hotel_project.exception;

public class AdminIdNotFoundException extends RuntimeException {

	private String message = "Admin Id Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminIdNotFoundException() {
		super();
	}

}
