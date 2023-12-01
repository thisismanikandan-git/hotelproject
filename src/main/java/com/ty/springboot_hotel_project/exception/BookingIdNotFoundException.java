package com.ty.springboot_hotel_project.exception;

public class BookingIdNotFoundException extends RuntimeException {

	private String message = "Booking Id Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public BookingIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingIdNotFoundException() {
		super();
	}

}
