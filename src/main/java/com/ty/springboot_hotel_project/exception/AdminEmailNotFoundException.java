package com.ty.springboot_hotel_project.exception;

public class AdminEmailNotFoundException extends RuntimeException {

	private String message = "Admin Email Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public AdminEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public AdminEmailNotFoundException() {
		super();
	}

}
