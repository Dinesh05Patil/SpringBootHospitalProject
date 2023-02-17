package com.ty.springboot_hospital_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.repository.EncounterRepository;

@Repository
public class EncounterDao {
	
	@Autowired
	private EncounterRepository encounterRepository;
	
	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepository.save(encounter);
	}
	
	public Encounter updatEncounter(int eid,Encounter encounter) {
		if(encounterRepository.findById(eid).isPresent()) {
			encounter.setId(eid);
			return encounterRepository.save(encounter);
		}else {
			return null;
		}
		
	}
	
	public Encounter getById(int eid) {
		if(encounterRepository.findById(eid).isPresent()) {
			
		
		return encounterRepository.findById(eid).get();
		}else {
			return null;
		}
	}
	
	public Encounter deletEncounter(int eid) {
		if(encounterRepository.findById(eid).isPresent()) {
			Encounter encounter=encounterRepository.findById(eid).get();
			encounterRepository.delete(encounter);
			return encounter;
		}else {
			return null;
		}
	}

}
