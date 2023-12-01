package com.ty.springboot_hotel_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hotel_project.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	@Query("select a from Admin a where a.admin_email=?1")
	public Admin getAdminByEmial(String admin_email);

}
