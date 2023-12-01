package com.ty.springboot_hotel_project.exception;

public class RoomIdNotFoundException extends RuntimeException {

	private String message = "Room Id Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomIdNotFoundException() {
		super();
	}

}
