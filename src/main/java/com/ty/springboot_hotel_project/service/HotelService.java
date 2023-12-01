package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.BookingDao;
import com.ty.springboot_hotel_project.dao.HotelDao;
import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.exception.HotelIdNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class HotelService {

	@Autowired
	private HotelDao dao;

	@Autowired
	private BookingDao bookingDao;

	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel) {
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		structure.setMessage("Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHotel(hotel));
		return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(int hid, Hotel hotel) {
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		Hotel hotel2 = dao.getHotelById(hid);
		if (hotel2 != null) {
			hotel.setHotel_id(hid);
			structure.setMessage("Updated Successufully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateHotel(hotel));
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hid) {
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		Hotel hotel2 = dao.getHotelById(hid);
		if (hotel2 != null) {
			structure.setMessage("Deleted Successufully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteHotel(hid));
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(int hid) {
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		Hotel hotel2 = dao.getHotelById(hid);
		if (hotel2 != null) {
			structure.setMessage("Found Successufully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hotel2);
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.FOUND);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

//	public ResponseEntity<ResponseStructure<Hotel>> updateHotelReview(int hid) {
//		ResponseStructure<Hotel> structure = new ResponseStructure<>();
//		Hotel hotel = dao.getHotelById(hid);
//		List<Booking> list = bookingDao.getAllBookings();
//		int count = 0;
//		for (Booking b : list) {
//			count += b.getRating();
//		}
//		hotel.setHotel_rating(count / list.size());
//		structure.setMessage("Hotel Updated by review Successufully....");
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setData(hotel);
//		return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
//	}

}
