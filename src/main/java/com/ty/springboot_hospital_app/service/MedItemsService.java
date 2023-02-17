package com.ty.springboot_hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.MedItemsDao;
import com.ty.springboot_hospital_app.dao.MedOrderDao;
import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class MedItemsService {

	@Autowired
	private MedItemsDao medItemsDao;

	@Autowired
	private MedOrderDao medOrderDao;

	public ResponseEntity<ResponseStructre<MedItems>> saveMedItems(MedItems medItems, int mid) {

		MedOrder medOrder = medOrderDao.getMedOrderById(mid);
		if (medOrder!= null) {
			medItems.setMedOrder(medOrder);
			ResponseStructre<MedItems> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully saved Meditems");
			responseStructre.setStatus(HttpStatus.CREATED.value());
			responseStructre.setData(medItemsDao.saveMedItems(medItems));

			return new ResponseEntity<ResponseStructre<MedItems>>(responseStructre, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructre<MedItems>> updateMedItems(MedItems medItems, int mid) {
		MedItems daoMedItems = medItemsDao.getMedItemsById(mid);
		if (daoMedItems != null) {
			medItems.setMedOrder(daoMedItems.getMedOrder());
			ResponseStructre<MedItems> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully updated Meditems");
			responseStructre.setStatus(HttpStatus.OK.value());
			responseStructre.setData(medItemsDao.updateMedItems(daoMedItems, mid));

			return new ResponseEntity<ResponseStructre<MedItems>>(responseStructre, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for given medorder");
		}
	}
	
	public ResponseEntity<ResponseStructre<MedItems>> deleteMedItems(int mid) {
		MedItems daoMedItems=medItemsDao.deleteMedItems(mid);
		if(daoMedItems!=null) {
			ResponseStructre<MedItems> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully deleted Meditems");
			responseStructre.setStatus(HttpStatus.OK.value());
			responseStructre.setData(daoMedItems);
			
			return new ResponseEntity<ResponseStructre<MedItems>> (responseStructre,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException("Id not found for given meditems");
		}
	}
	
	public ResponseEntity<ResponseStructre<MedItems>> getMedItemsById(int mid){
		MedItems daoMedItems=medItemsDao.getMedItemsById(mid);
		if(daoMedItems!=null) {
			ResponseStructre<MedItems> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully found Meditems");
			responseStructre.setStatus(HttpStatus.FOUND.value());
			responseStructre.setData(medItemsDao.getMedItemsById(mid));
			
			return new ResponseEntity<ResponseStructre<MedItems>> (responseStructre,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Id not found for given meditems");
			
		}
	}
	
	public ResponseEntity<ResponseStructre<List<MedItems>>> getAllMedItemsByMedOrder(int mid){
		List<MedItems> daoMedItems=medItemsDao.getAllMedItemsByMedOrder(mid);
		if(daoMedItems!=null) {
			ResponseStructre<List<MedItems>> responseStructre=new ResponseStructre<>();
			responseStructre.setMeesage("successfully found all Meditems");
			responseStructre.setStatus(HttpStatus.FOUND.value());
			responseStructre.setData(daoMedItems);
			
			return new ResponseEntity<ResponseStructre<List<MedItems>>> (responseStructre,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException("Id not found for given medorder");
		}
	}
	

}
