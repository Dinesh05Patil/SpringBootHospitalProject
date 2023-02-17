package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.AddressDao;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructre<Address>> saveAddress(Address address){
		ResponseStructre<Address> responseStructure=new ResponseStructre<Address>();
		responseStructure.setMeesage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveAddress(address));
		
		return new ResponseEntity<ResponseStructre<Address>>(responseStructure, HttpStatus.CREATED);
	}
	
public ResponseEntity<ResponseStructre<Address>> updateAddress(int id ,Address address){
		
		Address daoAddress=dao.updateAddress(id, address);
		if(daoAddress!=null) {
			ResponseStructre<Address> responseStructure=new ResponseStructre<Address>();
			responseStructure.setMeesage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoAddress);
			
			return new ResponseEntity<ResponseStructre<Address>>(responseStructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id not found for given address");
		}
		
	}
	
public ResponseEntity<ResponseStructre<Address>> deleteAddress(int id){
	Address daoAddress=dao.deleteAddress(id);
	if(daoAddress!=null) {
		ResponseStructre<Address> responseStructure=new ResponseStructre<Address>();
		responseStructure.setMeesage("successfully deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(daoAddress);
		
		return new ResponseEntity<ResponseStructre<Address>>(responseStructure, HttpStatus.OK);
	}else {
		throw new IdNotFoundException("Id not found for given address");
		
	}
}
public ResponseEntity<ResponseStructre<Address>> getAddressById(int id){
	Address daoAddress=dao.getAddressById(id);
	if(daoAddress!=null) {
		ResponseStructre<Address> responseStructure=new ResponseStructre<Address>();
		responseStructure.setMeesage("Found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(daoAddress);
		
		return new ResponseEntity<ResponseStructre<Address>>(responseStructure, HttpStatus.FOUND);
	}else {
		throw new IdNotFoundException("Id not found for given address");
		
	}
}

}
