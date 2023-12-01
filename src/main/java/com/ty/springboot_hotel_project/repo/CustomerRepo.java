package com.ty.springboot_hotel_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hotel_project.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.customer_email=?1")
	public Customer getCustomerByEmail(String customer_email);

}
