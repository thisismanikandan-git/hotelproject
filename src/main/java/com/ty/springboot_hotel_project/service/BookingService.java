package com.ty.springboot_hotel_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.BookingDao;
import com.ty.springboot_hotel_project.dao.CustomerDao;
import com.ty.springboot_hotel_project.dao.RoomDao;
import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.exception.BookingBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.BookingIdNotFoundException;
import com.ty.springboot_hotel_project.exception.MaxNumberPeopleException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private CustomerDao customerDao;

	ResponseStructure<Booking> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking, int cid, int rid) {
		Room room = roomDao.getRoomById(rid);
		room.setAvailability("N");
		if (booking.getNo_of_people() <= room.getMax_no_of_people()) {
			Room room2 = roomDao.updatRoom(room);
			Customer customer = customerDao.getCustomerById(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime check_in_date = LocalDateTime.now();
			booking.setCheck_in_date(check_in_date);
			structure.setMessage("Booking Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
		} else {
			throw new MaxNumberPeopleException();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(int bid, Booking booking) {
		Booking booking2 = dao.getBookingById(bid);
		if (booking2 != null) {
			if (booking.getNo_of_people() <= booking2.getRoom().getMax_no_of_people()) {
				booking.setId(bid);
				booking.setCustomer(booking2.getCustomer());
				booking.setRoom(booking2.getRoom());
				booking.setCheck_in_date(booking2.getCheck_in_date());
				booking.setCheck_out_date(booking2.getCheck_out_date());
				structure.setMessage("Booking Updated Successufully....");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateBooking(booking));
				return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
			} else {
				throw new MaxNumberPeopleException();
			}
		} else {
			throw new BookingIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bid) {
		Booking booking2 = dao.getBookingById(bid);
		if (booking2 != null) {
			structure.setMessage("booking deleted Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteBooking(booking2));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		} else {
			throw new BookingIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int bid) {
		Booking booking2 = dao.getBookingById(bid);
		if (booking2 != null) {
			structure.setMessage("booking fetched Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(booking2);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.FOUND);
		} else {
			throw new BookingIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Booking>>> getBookings() {
		ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();
		if (dao.getAllBookings() != null) {
			responseStructure.setMessage("bookings feted Successufully....");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.getAllBookings());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BookingBodyNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Booking>> closeBooking(int bid) {
		Booking booking = dao.getBookingById(bid);
		if (booking != null) {
			LocalDateTime check_out_time = LocalDateTime.now();
			booking.setCheck_out_date(check_out_time);
			Room room = booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			structure.setMessage("Successfully Closed The Booking");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateBooking(booking));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.OK);
		}
		throw new BookingIdNotFoundException();
	}

//	public ResponseEntity<ResponseStructure<List<Room>>> getRoomsByCheckOutAndCheckIn(String in, String out)
//			throws ParseException {
//		List<Room> sendList = new ArrayList<>();
//		List<Room> list = roomDao.getRoomByAvailability("Y");
//		for (Room r : list) {
//			sendList.add(r);
//		}
//		List<Booking> list2 = dao.getAllBookings();
//		for (Booking b : list2) {
//			String from = b.getCheck_in_date();
//			String to = b.getCheck_out_date();
//
//			Date d_from = new SimpleDateFormat("yyyy-MM-dd").parse(from);
//			Date d_to = new SimpleDateFormat("yyyy-MM-dd").parse(to);
//
//			long t1 = d_from.getTime();
//			long t2 = d_to.getTime();
//
//			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//
//			if (t1 < t2) {
//				int count = 0;
//				for (long i = t1; i <= t2; i += 86400000) {
//					if ((f.format(i)).equals(in) || (f.format(i)).equals(out))
//						count++;
//				}
//				if (count == 0) {
//					sendList.add(b.getRoom());
//				}
//			}
//		}
//		ResponseStructure<List<Room>> responseStructure = new ResponseStructure<>();
//		responseStructure.setMessage("Rooms fetched Successufully....");
//		responseStructure.setStatus(HttpStatus.FOUND.value());
//		responseStructure.setData(sendList);
//		return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure, HttpStatus.FOUND);
//
//	}

}
