package com.ty.springboot_hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.EncounterDao;
import com.ty.springboot_hospital_app.dao.MedOrderDao;
import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	
	@Autowired
	private EncounterDao encounterDao;
	
	
	public ResponseEntity<ResponseStructre<MedOrder>> saveMedOrder(MedOrder medOrder,int eid){
		
		Encounter encounter= encounterDao.getById(eid);
		medOrder.setEncounter(encounter);
		
		ResponseStructre<MedOrder> responseStructre = new ResponseStructre<>();
		responseStructre.setMeesage("successfully saved MedOrder");
		responseStructre.setStatus(HttpStatus.CREATED.value());
		responseStructre.setData(medOrderDao.saveMedOrder(medOrder));
		
		return new ResponseEntity<ResponseStructre<MedOrder>> (responseStructre,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructre<MedOrder>> updateMedOrder(MedOrder medOrder,int mid){
		
		MedOrder daoMedOrder=medOrderDao.getMedOrderById(mid);
		if(daoMedOrder!=null) {
			medOrder.setEncounter(daoMedOrder.getEncounter());
			ResponseStructre<MedOrder> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully updated MedOrder");
			responseStructre.setStatus(HttpStatus.OK.value());
			responseStructre.setData(medOrderDao.updateMedOrder(medOrder, mid));
			
			return new ResponseEntity<ResponseStructre<MedOrder>> (responseStructre,HttpStatus.OK);	
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructre<MedOrder>> deleteMedOrder(int mid){
		MedOrder medOrder=medOrderDao.deleteMedOrder(mid);
		if(medOrder!=null) {
			
			ResponseStructre<MedOrder> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully deleted MedOrder");
			responseStructre.setStatus(HttpStatus.OK.value());
			responseStructre.setData(medOrder);
			return new ResponseEntity<ResponseStructre<MedOrder>> (responseStructre,HttpStatus.OK);	
		}else {
			throw new IdNotFoundException();
			
		}
	}
	
	public ResponseEntity<ResponseStructre<MedOrder>> getMedOrder(int mid){
		MedOrder medOrder=medOrderDao.getMedOrderById(mid);
		if(medOrder!=null) {
			ResponseStructre<MedOrder> responseStructre = new ResponseStructre<>();
			responseStructre.setMeesage("successfully found MedOrder");
			responseStructre.setStatus(HttpStatus.FOUND.value());
			responseStructre.setData(medOrder);
			return new ResponseEntity<ResponseStructre<MedOrder>> (responseStructre,HttpStatus.FOUND);		
		} else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructre<List<MedOrder>>> getAllMedOrderByEncounter(int eid){
		List<MedOrder> daMedOrder=medOrderDao.getAllMedOrderByEncounter(eid);
		if(daMedOrder!=null) {
			ResponseStructre<List<MedOrder>> responseStructre=new ResponseStructre<>();
			responseStructre.setMeesage("found all");
			responseStructre.setStatus(HttpStatus.FOUND.value());
			responseStructre.setData(daMedOrder);
			return new ResponseEntity<ResponseStructre<List<MedOrder>>> (responseStructre,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}

}
