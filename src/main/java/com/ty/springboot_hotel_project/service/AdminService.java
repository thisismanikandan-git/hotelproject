package com.ty.springboot_hotel_project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.AdminDao;
import com.ty.springboot_hotel_project.dao.BookingDao;
import com.ty.springboot_hotel_project.dao.HotelDao;
import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.exception.AdminBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.AdminEmailNotFoundException;
import com.ty.springboot_hotel_project.exception.AdminIdNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private BookingDao bookingDao;

	ResponseStructure<Admin> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin, int hid) {
		Hotel hotel = hotelDao.getHotelById(hid);
		admin.setHotel(hotel);
		Admin admin2 = dao.saveAdmin(admin);
		if (admin2 != null) {
			structure.setMessage("Admin Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(admin2);
		}
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int aid, Admin admin) {
		Admin admin2 = dao.getAdminById(aid);
		admin.setHotel(admin2.getHotel());
		if (admin2 != null) {
			admin.setAdmin_id(aid);
			structure.setMessage("admin updated Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updatAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int aid) {
		Admin admin2 = dao.getAdminById(aid);
		if (admin2 != null) {
			structure.setMessage("admin deleted Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteAdmin(admin2));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int aid) {
		Admin admin2 = dao.getAdminById(aid);
		if (admin2 != null) {
			structure.setMessage("admin fetched Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String email) {
		Admin admin2 = dao.getAdminByEmail(email);
		if (admin2 != null) {
			structure.setMessage("admin fetched Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminEmailNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> getAdmins() {
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<>();
		if (dao.getAllAdmins() != null) {
			responseStructure.setMessage("admins fetched Successufully....");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.getAllAdmins());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AdminBodyNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String email, String password) {
		Admin admin2 = dao.getAdminByEmail(email);
		if (admin2.getAdmin_password().equals(password)) {
			structure.setMessage("Admin Logged In Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} else {
			structure.setMessage("Enter Valid Email and Password....");
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.BAD_REQUEST);
		}
	}

//	public ResponseEntity<ResponseStructure<List<Booking>>> getChekedOutBookings() {
//		ResponseStructure<List<Booking>> structure = new ResponseStructure<>();
//		String cdate = LocalDate.now().toString();
//		List<Booking> list = bookingDao.getAllBookings();
//		List<Booking> newlist = new ArrayList<>();
//		for (Booking b : list) {
//			if (b.getCheck_out_date().equals(cdate))
//				newlist.add(b);
//		}
//		structure.setMessage("Todays Checkouts Fetched Successufully....");
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setData(newlist);
//		return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.OK);
//	}

}
