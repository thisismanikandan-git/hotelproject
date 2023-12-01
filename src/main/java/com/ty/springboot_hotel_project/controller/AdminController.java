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

import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.service.AdminService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@ApiOperation(value = "Save Admin", notes = "Api is used to Save the Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Admin Not Saved Give Proper Input") })
	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Valid @RequestBody Admin admin, @RequestParam int hid) {
		return service.saveAdmin(admin, hid);
	}

	@ApiOperation(value = "Update Admin", notes = "Api is used to update Admin with the id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Admin Not Updated Give Proper Input") })
	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@Valid @RequestParam int aid,
			@RequestBody Admin admin) {
		return service.updateAdmin(aid, admin);
	}

	@ApiOperation(value = "Delete Admin", notes = "Api is used to Delete the Admin")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Admin Not deleted Give Proper Input") })
	@DeleteMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@Valid @RequestParam int aid) {
		return service.deleteAdmin(aid);
	}

	@ApiOperation(value = "Get Admin", notes = "Api is used to Get the Admin By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Admin"),
			@ApiResponse(code = 404, message = "Admin Not Found Give Proper Input") })
	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@Valid @RequestParam int aid) {
		return service.getAdminById(aid);
	}

	@ApiOperation(value = "Get All Admins", notes = "Api is used to Get the All Admins ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Admins"),
			@ApiResponse(code = 404, message = "Admins Not Found Give Proper Input") })
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		return service.getAdmins();
	}

	@ApiOperation(value = "Get Admin By Email", notes = "Api is used to Get the Admin By Email")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The Admin"),
			@ApiResponse(code = 404, message = "Admin Not Found Give Proper Input") })
	@GetMapping("/adminbyemail")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@Valid @RequestParam String email) {
		return service.getAdminByEmail(email);
	}

	@ApiOperation(value = "Admin Login", notes = "Api is used to Login the Admin By Email and Password")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In"),
			@ApiResponse(code = 404, message = "Not Logged In Check Your Credentail") })
	@GetMapping("/adminlogin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@Valid @RequestParam String email,
			@RequestParam String password) {
		return service.loginAdmin(email, password);
	}

//	@ApiOperation(value = "Get Todays CheckOuts ", notes = "Api is used to Get The All Todays Checkouts")
//	@ApiResponses(value = { @ApiResponse(code = 302, message = "Successfully Found The All The Checkouts"),
//			@ApiResponse(code = 404, message = "Not Found ") })
//	@GetMapping("/getcheckoutbookings")
//	public ResponseEntity<ResponseStructure<List<Booking>>> getChekedOutBookings() {
//		return service.getChekedOutBookings();
//	}

}
