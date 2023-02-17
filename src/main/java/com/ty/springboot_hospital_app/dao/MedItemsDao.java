package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.repository.MedItemsRepository;

@Repository
public class MedItemsDao {

	@Autowired
	private MedItemsRepository medItemsRepository;

	@Autowired
	private MedOrderDao medOrderDao;

	public MedItems saveMedItems(MedItems medItems) {
		return medItemsRepository.save(medItems);
	}

	public MedItems updateMedItems(MedItems medItems, int mid) {
		if (medItemsRepository.findById(mid).isPresent()) {
			medItems.setId(mid);
			return medItemsRepository.save(medItems);
		} else {
			return null;
		}
	}

	public MedItems deleteMedItems(int mid) {
		if (medItemsRepository.findById(mid).isPresent()) {
			MedItems medItems = medItemsRepository.findById(mid).get();
			medItemsRepository.delete(medItems);
			return medItems;
		} else {
			return null;
		}
	}

	public MedItems getMedItemsById(int mid) {
		if (medItemsRepository.findById(mid).isPresent()) {
			return medItemsRepository.findById(mid).get();
		} else {
			return null;
		}
	}

	public List<MedItems> getAllMedItemsByMedOrder(int mid) {
		MedOrder medOrder = medOrderDao.getMedOrderById(mid);
		if (medOrder != null) {
			return medItemsRepository.getByMedOrder(medOrder);
		} else {
			return null;
		}
	}

}
