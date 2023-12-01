package com.ty.springboot_hotel_project.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hotel_project.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseStructure<String> structure = new ResponseStructure<>();

	@ExceptionHandler(HotelIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hotelIdNotFoundException(HotelIdNotFoundException ex) {
		structure.setMessage("Given Hotel Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> adminIdNotFoundException(AdminIdNotFoundException ex) {
		structure.setMessage("Given Admin Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminBodyNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> adminBodyNotFoundException(AdminBodyNotFoundException ex) {
		structure.setMessage("Given Admin Body Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> adminEmailNotFoundException(AdminEmailNotFoundException ex) {
		structure.setMessage("Given Admin Email Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFoundException(CustomerIdNotFoundException ex) {
		structure.setMessage("Given Customer Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerBodyNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> customerBodyNotFoundException(CustomerBodyNotFoundException ex) {
		structure.setMessage("Given Customer Body Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> customerEmailNotFoundException(CustomerEmailNotFoundException ex) {
		structure.setMessage("Given Customer Email Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> roomIdNotFoundException(RoomIdNotFoundException ex) {
		structure.setMessage("Given Room Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomBodyNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> roomBodyNotFoundException(RoomBodyNotFoundException ex) {
		structure.setMessage("Given Room Body Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomTypeNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> roomTypeNotFoundException(RoomTypeNotFoundException ex) {
		structure.setMessage("Given Room Type is Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomNumberNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> roomNoNotFoundException(RoomNumberNotFoundException ex) {
		structure.setMessage("Given Room Number Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> bookingIdNotFoundException(BookingIdNotFoundException ex) {
		structure.setMessage("Given Booking Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookingBodyNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> bookingBodyNotFoundException(BookingBodyNotFoundException ex) {
		structure.setMessage("Given Booking Body Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, org.springframework.http.HttpStatus status, WebRequest request) {
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (ObjectError er : error) {
			String feildName = ((FieldError) er).getField();
			String message = ((FieldError) er).getDefaultMessage();
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MaxNumberPeopleException.class)
	public ResponseEntity<ResponseStructure<String>> handleMaxNumberPeopleException(MaxNumberPeopleException ex) {
		structure.setMessage("Max limit of people for the particular room reached");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> set = ex.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for (ConstraintViolation<?> constraintViolationException : set) {
			String name = constraintViolationException.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(UnexpectedTypeException.class)
//	public ResponseEntity<ResponseStructure<String>> unExpectedTypeException(UnexpectedTypeException ex) {
//		ResponseStructure<String> structure = new ResponseStructure<>();
//		structure.setMessage("Validate Only String Type Atrribute");
//		structure.setData("Validate Only String Type Atrribute");
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
//	}

//	@ExceptionHandler(IncorrectResultSizeDataAccessException.class)
//	public ResponseEntity<ResponseStructure<String>> IncorrectResultSizeDataAccessExceptionhandler(
//			IncorrectResultSizeDataAccessException accessException) {
//		ResponseStructure<String> structure = new ResponseStructure<>();
//		structure.setMessage(accessException.getMessage());
//		structure.setData(accessException.getLocalizedMessage());
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
//	}

//	@ExceptionHandler(ParseException.class)
//	public ResponseEntity<ResponseStructure<String>> ParseExceptionhandler(ParseException parseException) {
//		ResponseStructure<String> structure = new ResponseStructure<>();
//		structure.setMessage(parseException.getMessage());
//		structure.setData(parseException.getLocalizedMessage());
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
//	}

}
