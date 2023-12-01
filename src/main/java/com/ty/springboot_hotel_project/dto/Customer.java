package com.ty.springboot_hotel_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@NotBlank(message = "Customer Name should not blank")
	@NotNull(message = "Customer Name should not be null")
	private String customer_name;
	@NotBlank(message = "Customer Address should not blank")
	@NotNull(message = "Customer Address should not be null")
	private String customer_address;
	@NotBlank(message = "Customer Email should not blank")
	@NotNull(message = "Customer Email should not be null")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String customer_email;
	@NotBlank(message = "Customer Password should not blank")
	@NotNull(message = "Customer Password should not be null")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 specialCharacter,1 number)")
	private String customer_password;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long customer_phone;
	@NotBlank(message = "customer adhar should not blank")
	@NotNull(message = "customer adhar should not be null")
	@Pattern(regexp = "[1-9][1-9]{11}", message = "Invalid Aadhar")//shd give 12 numbers
	private String customer_aadhar;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public long getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(long customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_aadhar() {
		return customer_aadhar;
	}

	public void setCustomer_aadhar(String customer_aadhar) {
		this.customer_aadhar = customer_aadhar;
	}

}
