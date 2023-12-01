package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.repo.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo repo;

	public Booking saveBooking(Booking booking) {
		return repo.save(booking);
	}

	public Booking updateBooking(Booking booking) {
		return repo.save(booking);
	}

	public Booking deleteBooking(Booking booking) {
		repo.delete(booking);
		return booking;
	}

	public Booking getBookingById(int bid) {
		if (repo.findById(bid).isPresent())
			return repo.findById(bid).get();
		else
			return null;
	}

	public List<Booking> getAllBookings() {
		return repo.findAll();
	}

	public Booking getBookingByCheckIn(String check_in_date) {
		if (repo.getBookingByCheckIn(check_in_date) != null)
			return repo.getBookingByCheckIn(check_in_date);
		else
			return null;
	}

	public Booking getBookingByCheckOut(String check_out_date) {
		if (repo.getBookingByCheckOut(check_out_date) != null)
			return repo.getBookingByCheckOut(check_out_date);
		else
			return null;
	}

}
