package com.ty.springboot_hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStructre<Person>> savePerson(Person person){
		ResponseStructre<Person> structre=new ResponseStructre<>();
		structre.setMeesage("successfully saved person");
		structre.setStatus(HttpStatus.CREATED.value());
		structre.setData(dao.savePerson(person));
		
		return new ResponseEntity<ResponseStructre<Person>>(structre,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructre<Person>> updatePerson(int id, Person person){
		
		Person person2=dao.updatePerson(id, person);
		if(person2!=null) {
			ResponseStructre<Person> structre=new ResponseStructre<>();
			structre.setMeesage("successfully updated person");
			structre.setStatus(HttpStatus.OK.value());
			structre.setData(person2);
			
			return new ResponseEntity<ResponseStructre<Person>>(structre,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
				
	}
	
	
	public ResponseEntity<ResponseStructre<Person>> deletePerson(int id){
		Person person=dao.deletePerson(id);
		if(person!=null) {
			ResponseStructre<Person> responseStructure=new ResponseStructre<Person>();
			responseStructure.setMeesage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			
			return new ResponseEntity<ResponseStructre<Person>>(responseStructure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructre<Person>> getPersonById(int id){
		Person person=dao.deletePerson(id);
		if(person!=null) {
			ResponseStructre<Person> responseStructure=new ResponseStructre<Person>();
			responseStructure.setMeesage("successfully found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			
			return new ResponseEntity<ResponseStructre<Person>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}

}
