package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.CustomerDao;
import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.exception.CustomerBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerEmailNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerIdNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	ResponseStructure<Customer> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		Customer customer2 = dao.saveCustomer(customer);
		if (customer2 != null) {
			structure.setMessage("customer Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int cid, Customer customer) {
		Customer customer2 = dao.getCustomerById(cid);
		if (customer2 != null) {
			customer.setCustomer_id(cid);
			structure.setMessage("customer updated Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int cid) {
		Customer customer2 = dao.getCustomerById(cid);
		if (customer2 != null) {
			structure.setMessage("customer deleted Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteCustomer(customer2));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int cid) {
		Customer customer2 = dao.getCustomerById(cid);
		if (customer2 != null) {
			structure.setMessage("customer fetched Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(customer2);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(String email) {
		Customer customer2 = dao.getCustomerByEmail(email);
		if (customer2 != null) {
			structure.setMessage("customer fetched Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(customer2);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.FOUND);
		} else {
			throw new CustomerEmailNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomers() {
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		if (dao.getAllCustomers() != null) {
			responseStructure.setMessage("customers feted Successufully....");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.getAllCustomers());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerBodyNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(String email, String password) {
		Customer customer = dao.getCustomerByEmail(email);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		if (customer.getCustomer_password().equals(password)) {
			responseStructure.setMessage("Customer Logged In Successufully....");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("enter valid email and password....");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.BAD_REQUEST);
		}
	}

}
