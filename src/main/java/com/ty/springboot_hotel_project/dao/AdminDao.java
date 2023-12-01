package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.repo.AdminRepo;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepo repo;

	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}

	public Admin updatAdmin(Admin admin) {
		return repo.save(admin);
	}

	public Admin deleteAdmin(Admin admin) {
		repo.delete(admin);
		return admin;
	}

	public Admin getAdminById(int aid) {
		if (repo.findById(aid).isPresent()) {
			return repo.findById(aid).get();
		}
		return null;
	}

	public List<Admin> getAllAdmins() {
		return repo.findAll();
	}

	public Admin getAdminByEmail(String admin_email) {
		return repo.getAdminByEmial(admin_email);
	}

}
