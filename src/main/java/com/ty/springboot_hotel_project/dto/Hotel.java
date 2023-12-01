package com.ty.springboot_hotel_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	@NotNull(message = "Hotel Name can't be null")
	@NotBlank(message = "Hotel Name can't be blank")
	private String hotel_name;
	@NotNull(message = "Hotel GST can't be null")
	@NotBlank(message = "Hotel GST can't be blank")
	private String hotel_gst;
	@NotNull(message = "Hotel Address can't be null")
	@NotBlank(message = "Hotel Address can't be blank")
	private String hotel_address;
	@NotNull(message = "Hotel Owner can't be null")
	@NotBlank(message = "Hotel Owner can't be blank")
	private String hotel_owner;
	@NotNull(message = "Hotel Manager can't be null")
	@NotBlank(message = "Hotel Manager can't be blank")
	private String hotel_manager;
	private int hotel_rating;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_gst() {
		return hotel_gst;
	}

	public void setHotel_gst(String hotel_gst) {
		this.hotel_gst = hotel_gst;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getHotel_owner() {
		return hotel_owner;
	}

	public void setHotel_owner(String hotel_owner) {
		this.hotel_owner = hotel_owner;
	}

	public String getHotel_manager() {
		return hotel_manager;
	}

	public void setHotel_manager(String hotel_manager) {
		this.hotel_manager = hotel_manager;
	}

	public int getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(int hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

}
