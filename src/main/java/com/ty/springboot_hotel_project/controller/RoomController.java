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

import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.service.RoomService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class RoomController {

	@Autowired
	private RoomService service;

	@ApiOperation(value = "Save Room", notes = "Api is used to Save the Room")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Room Not Saved Give Proper Input") })
	@PostMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@Valid @RequestBody Room room, @RequestParam int hid) {
		return service.saveRoom(room, hid);
	}

	@ApiOperation(value = "Update Room", notes = "Api is used to update Room with the id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Room Not Updated Give Proper Input") })
	@PutMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@Valid @RequestParam int rid, @RequestBody Room room) {
		return service.updateRoom(rid, room);
	}

	@ApiOperation(value = "Delete Room", notes = "Api is used to Delete the Room")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Room Not deleted Give Proper Input") })
	@DeleteMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(@Valid @RequestParam int rid) {
		return service.deleteRoom(rid);
	}

	@ApiOperation(value = "Get Room By Id", notes = "Api is used to Get the Room By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Room"),
			@ApiResponse(code = 404, message = "Room Not Found Give Proper Input") })
	@GetMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> getRoomById(@Valid @RequestParam int rid) {
		return service.getRoomById(rid);
	}

	@ApiOperation(value = "Get All Rooms", notes = "Api is used to Get the All Rooms ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Rooms"),
			@ApiResponse(code = 404, message = "Rooms Not Found Give Proper Input") })
	@GetMapping("/rooms")
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		return service.getRooms();
	}

	@ApiOperation(value = "Get Rooms By Type", notes = "Api is used to Get the Rooms By Room Type")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Rooms"),
			@ApiResponse(code = 404, message = "Rooms Not Found Give Proper Input") })
	@GetMapping("/roombytype")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByType(@Valid @RequestParam String room_type) {
		return service.getRoomByType(room_type);
	}

	@ApiOperation(value = "Get Room By Number", notes = "Api is used to Get the Room By Room Number")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Room"),
			@ApiResponse(code = 404, message = "Room Not Found Give Proper Input") })
	@GetMapping("/roombyno")
	public ResponseEntity<ResponseStructure<Room>> getRoomByNo(@Valid @RequestParam String room_no) {
		return service.getRoomByNo(room_no);
	}

	@ApiOperation(value = "Get Rooms By Availability", notes = "Api is used to Get the Rooms By Room Avalability")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Rooms"),
			@ApiResponse(code = 404, message = "Rooms Not Found Give Proper Input") })
	@GetMapping("/roombyavailability")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(
			@Valid @RequestParam String availability) {
		return service.getRoomByAvailability(availability);
	}

}
