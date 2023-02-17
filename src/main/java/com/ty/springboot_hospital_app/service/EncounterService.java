package com.ty.springboot_hospital_app.service;

import java.util.ArrayList;
import java.util.List;import org.hibernate.hql.spi.id.inline.AbstractInlineIdsBulkIdHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BranchDao;
import com.ty.springboot_hospital_app.dao.EncounterDao;
import com.ty.springboot_hospital_app.dao.PersonDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class EncounterService {
	
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;
	
	public ResponseEntity<ResponseStructre<Encounter>> saveEncounter(Encounter encounter,int pid,int bid){
		
		Person person=personDao.getPersonById(pid);
		Branch branch=branchDao.getBranchById(bid);
		
		encounter.setPerson(person);
		
		List<Branch> list=new ArrayList<>();
		list.add(branch);
		encounter.setBranchs(list);
		
		ResponseStructre<Encounter> responseStructre=new ResponseStructre<>();
		responseStructre.setMeesage("Encounter successfully saved");
		responseStructre.setStatus(HttpStatus.CREATED.value());
		responseStructre.setData(encounterDao.saveEncounter(encounter));
		
		return new ResponseEntity<ResponseStructre<Encounter>>(responseStructre,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructre<Encounter>> updateEncounter(Encounter encounter,int eid,int bid){
		Encounter daoEncounter=encounterDao.getById(eid);
		Branch branch=branchDao.getBranchById(bid);
		
		List<Branch>list=daoEncounter.getBranchs();
		list.add(branch);
		
		encounter.setBranchs(list);
		encounter.setPerson(daoEncounter.getPerson());
		
		ResponseStructre<Encounter> responseStructre=new ResponseStructre<>();
		responseStructre.setMeesage("successfully updated");
		responseStructre.setStatus(HttpStatus.CREATED.value());
		responseStructre.setData(encounterDao.updatEncounter(eid, daoEncounter));
		
		return new ResponseEntity<ResponseStructre<Encounter>> (responseStructre,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructre<Encounter>> deleteEncounter(int id){
		Encounter encounter=encounterDao.deletEncounter(id);
		if(encounter!=null) {
			ResponseStructre<Encounter> responseStructre=new ResponseStructre<>();
			responseStructre.setMeesage("successfully deleted encounter");
			responseStructre.setStatus(HttpStatus.OK.value());
			responseStructre.setData(encounter);
			
			return new ResponseEntity<ResponseStructre<Encounter>> (responseStructre,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException("Id not found for given encounter");
		}
	}
	
	public ResponseEntity<ResponseStructre<Encounter>> getEncounterById(int id){
		ResponseStructre<Encounter> structre=new ResponseStructre<>();
		Encounter encounter=encounterDao.getById(id);
		if(encounter!=null) {
			structre.setMeesage("successfully found branch");
			structre.setStatus(HttpStatus.FOUND.value());
			structre.setData(encounter);
			
			return new ResponseEntity<ResponseStructre<Encounter>> (structre,HttpStatus.FOUND);
			
		}else {
			throw new IdNotFoundException("Id not found for given encounter");
		}
	}
	
	

}
