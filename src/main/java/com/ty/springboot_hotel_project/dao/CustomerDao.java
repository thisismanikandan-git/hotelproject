package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepo repo;

	public Customer saveCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return repo.save(customer);
	}

	public Customer deleteCustomer(Customer customer) {
		repo.delete(customer);
		return customer;
	}

	public Customer getCustomerById(int cid) {
		if (repo.findById(cid).isPresent()) {
			return repo.findById(cid).get();
		}
		return null;
	}

	public Customer getCustomerByEmail(String email) {
		if (repo.getCustomerByEmail(email) != null) {
			return repo.getCustomerByEmail(email);
		}
		return null;
	}

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

}
