package com.ty.springboot_hospital_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(int pid, Person person) {
		if (personRepository.findById(pid).isPresent()) {
			person.setPid(pid);
			return personRepository.save(person);
		} else {
			return null;
		}
	}

	public Person deletePerson(int id) {
		if (personRepository.findById(id).isPresent()) {
			Person person = personRepository.findById(id).get();
			personRepository.delete(person);
			return person;
		} else {
			return null;
		}
	}

	public Person getPersonById(int id) {
		if (personRepository.findById(id).isPresent()) {
			return personRepository.findById(id).get();
		} else {
			return null;
		}

	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

}
