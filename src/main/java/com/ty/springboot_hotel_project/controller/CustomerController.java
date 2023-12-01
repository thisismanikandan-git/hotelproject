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

import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.service.CustomerService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@ApiOperation(value = "Save Customer", notes = "Api is used to Save the Customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Customer Not Saved Give Proper Input") })
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@Valid @RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}

	@ApiOperation(value = "Update Customer", notes = "Api is used to update Customer with the id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Customer Not Updated Give Proper Input") })
	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@Valid @RequestParam int cid,
			@RequestBody Customer customer) {
		return service.updateCustomer(cid, customer);
	}

	@ApiOperation(value = "Delete Customer", notes = "Api is used to Delete the Customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Customer Not deleted Give Proper Input") })
	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@Valid @RequestParam int cid) {
		return service.deleteCustomer(cid);
	}

	@ApiOperation(value = "Get Customer", notes = "Api is used to Get the Customer By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Customer"),
			@ApiResponse(code = 404, message = "Customer Not Found Give Proper Input") })
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@Valid @RequestParam int cid) {
		return service.getCustomerById(cid);
	}

	@ApiOperation(value = "Get All Customers", notes = "Api is used to Get the All Customers ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Admins"),
			@ApiResponse(code = 404, message = "Customers Not Found Give Proper Input") })
	@GetMapping("/customers")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		return service.getCustomers();
	}

	@ApiOperation(value = "Get Customer By Email", notes = "Api is used to Get the Customer By Email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Customer"),
			@ApiResponse(code = 404, message = "Customer Not Found Give Proper Input") })
	@GetMapping("/customerbyemail")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(@Valid @RequestParam String email) {
		return service.getCustomerByEmail(email);
	}

	@ApiOperation(value = "Customer Login", notes = "Api is used to Login the Customer By Email and Password")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In"),
			@ApiResponse(code = 404, message = "Not Logged In Check Your Credentail") })
	@GetMapping("/customerlogin")
	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(@Valid @RequestParam String email,
			@RequestParam String password) {
		return service.loginCustomer(email, password);
	}

}
