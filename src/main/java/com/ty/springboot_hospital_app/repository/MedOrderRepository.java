package com.ty.springboot_hospital_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder	, Integer> {
	public List<MedOrder> getByEncounter(Encounter encounter);
}
