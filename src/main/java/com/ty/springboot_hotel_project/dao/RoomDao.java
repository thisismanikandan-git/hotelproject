package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.repo.RoomRepo;

@Repository
public class RoomDao {

	@Autowired
	private RoomRepo repo;

	public Room saveRoom(Room room) {
		return repo.save(room);
	}

	public Room updatRoom(Room room) {
		return repo.save(room);
	}

	public Room deleteRoom(Room room) {
		repo.delete(room);
		return room;
	}

	public Room getRoomById(int rid) {
		if (repo.getRoomById(rid) != null) {
			return repo.getRoomById(rid);
		}
		return null;
	}

	public List<Room> getAllRooms() {
		return repo.findAll();
	}

	public List<Room> getRoomByType(String room_type) {
		List<Room> rooms = repo.getRoomByType(room_type);
		if (rooms != null) {
			return rooms;
		}
		return null;
	}

	public Room getRoomByNo(String room_no) {
		if (repo.getRoomByNo(room_no) != null) {
			return repo.getRoomByNo(room_no);
		}
		return null;
	}

	public List<Room> getRoomByAvailability(String availability) {
		return repo.getRoomByAvailability(availability);
	}

}
