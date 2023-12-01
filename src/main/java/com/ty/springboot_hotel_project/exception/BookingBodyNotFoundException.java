package com.ty.springboot_hotel_project.exception;

public class BookingBodyNotFoundException extends RuntimeException {

	private String message = "Booking Body Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public BookingBodyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingBodyNotFoundException() {
		super();
	}

}
