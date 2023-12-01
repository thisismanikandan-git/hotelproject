package com.ty.springboot_hotel_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hotel_project.dto.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	@Query("select r from Room r where r.room_type=?1")
	public List<Room> getRoomByType(String room_type);

	@Query("select r from Room r where r.room_no=?1")
	public Room getRoomByNo(String room_no);

	@Query("select r from Room r where r.availability=?1")
	public List<Room> getRoomByAvailability(String availability);

	@Query("select r from Room r where r.room_id=?1")
	public Room getRoomById(int rid);

}