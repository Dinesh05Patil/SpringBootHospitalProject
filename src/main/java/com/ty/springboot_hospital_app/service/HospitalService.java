package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructre<Hospital>> saveHospital(Hospital hospital) {
		
		ResponseStructre<Hospital> structre=new ResponseStructre<Hospital>();
		structre.setMeesage("Successfully saved");
		structre.setStatus(HttpStatus.CREATED.value());
		structre.setData(dao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructre<Hospital>>(structre,HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructre<Hospital>> updateHospital(int id,Hospital hospital) {
		Hospital daoHospital=dao.updateHospital(id, hospital);
		
		if(daoHospital!=null) {
			ResponseStructre<Hospital> structre=new ResponseStructre<Hospital>();
			structre.setMeesage("Successfully updated");
			structre.setStatus(HttpStatus.OK.value());
			structre.setData(daoHospital);
			
			return new ResponseEntity<ResponseStructre<Hospital>>(structre,HttpStatus.OK) ;
		}
		else {
			throw new IdNotFoundException("Id not found for given Hospital");
		}
	}
	
	public ResponseEntity<ResponseStructre<Hospital>> deleteHospital(int id){
		Hospital hospital=dao.deleteHospital(id);
		if(hospital!=null) {
			ResponseStructre<Hospital> structre1=new ResponseStructre<Hospital>();
			structre1.setMeesage("Successfully deleted");
			structre1.setStatus(HttpStatus.OK.value());
			structre1.setData(hospital);
			
			return new ResponseEntity<ResponseStructre<Hospital>>(structre1,HttpStatus.OK) ;
		}
		else {
			throw new IdNotFoundException("Id not found for given Hospital");
		}
		
	}
	
	public ResponseEntity<ResponseStructre<Hospital>> getHospitalById(int id){
		ResponseStructre<Hospital> structre1=new ResponseStructre<Hospital>();
		Hospital hospital=dao.getHospitalById(id);
		if(hospital!=null) {
		structre1.setMeesage("Successfully found hospital");
		structre1.setStatus(HttpStatus.FOUND.value());
		structre1.setData(hospital);
		
		return new ResponseEntity<ResponseStructre<Hospital>>(structre1,HttpStatus.FOUND) ;
		}
		else {
			throw new IdNotFoundException("Id not found for given Hospital");
		}
	}

}
