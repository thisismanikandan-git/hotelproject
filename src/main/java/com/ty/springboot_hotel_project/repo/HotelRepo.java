package com.ty.springboot_hotel_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hotel_project.dto.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
