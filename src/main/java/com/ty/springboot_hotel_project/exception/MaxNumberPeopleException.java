package com.ty.springboot_hotel_project.exception;

public class MaxNumberPeopleException extends RuntimeException {

	private String message = "We can't have these many number of people in the selected room";

	@Override
	public String getMessage() {
		return message;
	}

	public MaxNumberPeopleException() {
		super();
	}

	public MaxNumberPeopleException(String message) {
		super();
		this.message = message;
	}

}
