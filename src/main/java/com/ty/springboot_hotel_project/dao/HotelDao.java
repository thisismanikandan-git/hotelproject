package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.repo.HotelRepo;

@Repository
public class HotelDao {

	@Autowired
	private HotelRepo repo;

	public Hotel saveHotel(Hotel hotel) {
		return repo.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return repo.save(hotel);
	}

	public Hotel deleteHotel(int hid) {
		if (repo.findById(hid).isPresent()) {
			Hotel hotel = repo.findById(hid).get();
			repo.delete(hotel);
			return hotel;
		}
		return null;
	}

	public Hotel getHotelById(int hid) {
		if (repo.findById(hid).isPresent()) {
			return repo.findById(hid).get();
		}
		return null;
	}

}
