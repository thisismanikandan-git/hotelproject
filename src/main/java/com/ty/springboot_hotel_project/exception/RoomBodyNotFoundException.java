package com.ty.springboot_hotel_project.exception;

public class RoomBodyNotFoundException extends RuntimeException {

	private String message = "Room Body Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomBodyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomBodyNotFoundException() {
		super();
	}

}
