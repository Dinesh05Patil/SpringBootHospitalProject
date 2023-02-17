package com.ty.springboot_hospital_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Person;
import com.ty.springboot_hospital_app.service.PersonService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@ApiOperation(value = "Save Person" , notes = "Api is used to save Person  ")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created person"),	
					})
	@PostMapping("/person")
	public ResponseEntity<ResponseStructre<Person>> savePerson(@RequestBody Person person){
		return personService.savePerson(person);
	}
	
	
	@ApiOperation(value="updatePerson", notes = "api is used to update the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@PutMapping("/person")
	public ResponseEntity<ResponseStructre<Person>> updatePerson(@RequestParam int id ,@RequestBody Person person){
		return personService.updatePerson(id, person);
	}
	
	
	@ApiOperation(value="DeletePerson", notes = "api is used to delete the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@DeleteMapping("/person")
	public ResponseEntity<ResponseStructre<Person>> deletePerson(@RequestParam int id){
		return personService.deletePerson(id);
	}
	
	
	@ApiOperation(value="GetPerson", notes = "api is used to Get the Person for the given Person id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given Person Id not Found")
	})
	@GetMapping("/person")
	public ResponseEntity<ResponseStructre<Person>> getPersonById(@RequestParam int id){
		return personService.getPersonById(id);
	}

}
