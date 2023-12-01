package com.ty.springboot_hotel_project.exception;

public class AdminBodyNotFoundException extends RuntimeException {

	private String message = "Admin Body Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public AdminBodyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AdminBodyNotFoundException() {
		super();
	}

}
