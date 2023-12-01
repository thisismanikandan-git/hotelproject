package com.ty.springboot_hotel_project.exception;

public class RoomAvailabilityNotFoundException extends RuntimeException {

	private String message = "Room  Not Available";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomAvailabilityNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomAvailabilityNotFoundException() {
		super();
	}

}
