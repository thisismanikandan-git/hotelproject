package com.ty.springboot_hotel_project.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	@NotNull(message = "Room Number can't be null")
	@NotBlank(message = "Room Number can't be blank")
	private String room_no;
	@NotBlank(message = "Room Type should not blank")
	@NotNull(message = "Room Type should not be null")
	private String room_type;
	@NotBlank(message = "Room Price should not blank")
	@NotNull(message = "Room Price should not be null")
	private String room_price;
	@Min(value = 1)
	@Max(value = 10)
	private int no_of_beds;
	@Min(value = 1)
	@Max(value = 10)
	private int max_no_of_people;
	@NotBlank(message = "availibility should not blank")
	@NotNull(message = "availablility should not be null")
	@Pattern(regexp = "[Y,N]")
	private String availability;
	@Enumerated(EnumType.STRING)
	private Floor floor;
	@ManyToOne
	private Hotel hotel;

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_no() {
		return room_no;
	}

	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public int getNo_of_beds() {
		return no_of_beds;
	}

	public void setNo_of_beds(int no_of_beds) {
		this.no_of_beds = no_of_beds;
	}

	public int getMax_no_of_people() {
		return max_no_of_people;
	}

	public void setMax_no_of_people(int max_no_of_people) {
		this.max_no_of_people = max_no_of_people;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
