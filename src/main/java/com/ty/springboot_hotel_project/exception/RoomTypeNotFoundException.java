package com.ty.springboot_hotel_project.exception;

public class RoomTypeNotFoundException extends RuntimeException {

	private String message = "This Type of Room is Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomTypeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomTypeNotFoundException() {
		super();
	}

}
