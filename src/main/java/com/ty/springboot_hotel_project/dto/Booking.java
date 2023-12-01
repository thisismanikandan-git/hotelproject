package com.ty.springboot_hotel_project.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
	@Min(value = 1)
	@Max(value = 10)
	private int no_of_people;
	@Min(value = 1)
	@Max(value = 5)
	private int rating;
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Room room;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(LocalDateTime check_in_date) {
		this.check_in_date = check_in_date;
	}

	public LocalDateTime getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(LocalDateTime check_out_date) {
		this.check_out_date = check_out_date;
	}

	public int getNo_of_people() {
		return no_of_people;
	}

	public void setNo_of_people(int no_of_people) {
		this.no_of_people = no_of_people;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
