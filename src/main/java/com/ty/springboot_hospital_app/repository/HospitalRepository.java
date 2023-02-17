package com.ty.springboot_hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital	, Integer> {

	
	public Hospital findByEmail(String email);
}
