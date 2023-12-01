package com.ty.springboot_hotel_project.exception;

public class HotelIdNotFoundException extends RuntimeException {

	private String message = "Hotel Id Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	

	public HotelIdNotFoundException(String message) {
		super();
		this.message = message;
	}



	public HotelIdNotFoundException() {
		super();
	}

}
