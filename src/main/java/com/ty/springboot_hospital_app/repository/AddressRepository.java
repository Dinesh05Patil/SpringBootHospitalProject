package com.ty.springboot_hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
