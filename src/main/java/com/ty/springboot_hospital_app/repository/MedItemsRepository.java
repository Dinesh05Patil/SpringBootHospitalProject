package com.ty.springboot_hospital_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;

public interface MedItemsRepository extends JpaRepository<MedItems, Integer> {
	public List<MedItems> getByMedOrder(MedOrder medOrder);
}
