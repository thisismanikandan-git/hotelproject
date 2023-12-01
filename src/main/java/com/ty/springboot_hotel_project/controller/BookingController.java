package com.ty.springboot_hotel_project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.service.BookingService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@ApiOperation(value = "Save Booking", notes = "Api is used to Save the Booking")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Booking Not Saved Give Proper Input") })
	@PostMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@Valid @RequestBody Booking booking,
			@RequestParam int cid, @RequestParam int rid) {
		return service.saveBooking(booking, cid, rid);
	}

	@ApiOperation(value = "Update Booking", notes = "Api is used to Update the Booking")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Booking Not Updated Give Proper Input") })
	@PutMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@Valid @RequestParam int bid,
			@RequestBody Booking booking) {
		return service.updateBooking(bid, booking);
	}

	@ApiOperation(value = "Delete Booking", notes = "Api is used to Delete the Booking")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Booking Not deleted Give Proper Input") })
	@DeleteMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@Valid @RequestParam int bid) {
		return service.deleteBooking(bid);
	}

	@ApiOperation(value = "Get Booking", notes = "Api is used to Get the Booking By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Booking"),
			@ApiResponse(code = 404, message = "Booking Not Found Give Proper Input") })
	@GetMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@Valid @RequestParam int bid) {
		return service.getBookingById(bid);
	}

	@ApiOperation(value = "Get All Bookings", notes = "Api is used to Get the All Bookings ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Bookings"),
			@ApiResponse(code = 404, message = "Booking Not Found Give Proper Input") })
	@GetMapping("/bookings")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking() {
		return service.getBookings();
	}

	@ApiOperation(value = "Close Booking", notes = "Api is used to close the Booking")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully closed the Booking"),
			@ApiResponse(code = 404, message = "Booking Not Found Give Proper Input") })
	@PutMapping("/closebooking")
	public ResponseEntity<ResponseStructure<Booking>> closeBooking(@Valid @RequestParam int bid) {
		return service.closeBooking(bid);
	}

//	@ApiOperation(value = "Get Rooms", notes = "Api is used to Get the All Rooms By Checkout and CheckIn date ")
//	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Rooms"),
//			@ApiResponse(code = 404, message = "Rooms Not Found Give Proper Input") })
//	@GetMapping("/bookingsbycheck")
//	public ResponseEntity<ResponseStructure<List<Room>>> getRoomsByCheckOutAndCheckIn(
//			@Valid @RequestParam String check_in, @RequestParam String check_out) {
//		try {
//			return service.getRoomsByCheckOutAndCheckIn(check_in, check_out);
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
