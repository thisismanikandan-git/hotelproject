package com.ty.springboot_hotel_project.exception;

public class RoomNumberNotFoundException extends RuntimeException {

	private String message = "Room Number Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomNumberNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomNumberNotFoundException() {
		super();
	}

}
