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

import com.ty.springboot_hospital_app.dto.Encounter;
import com.ty.springboot_hospital_app.service.EncounterService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService encounterService;
	
	
	@ApiOperation(value = "Save Encounter" , notes = "Api is used to save Encounter with Person id and Branch id")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created Encounter"),
							@ApiResponse(code =404, message = "Id not found for given Person id and Branch id")	})
	@PostMapping("/encounter")
	public ResponseEntity<ResponseStructre<Encounter>> saveEncounter(@RequestBody Encounter encounter, @RequestParam int pid, @RequestParam int bid){
		return encounterService.saveEncounter(encounter, pid, bid);
		
	}
	
	
	@ApiOperation(value = "Update Encounter" , notes = "Api is used to update Encounter with branch id and encounter id")
	@ApiResponses(value = { @ApiResponse(code =200, message = "Successfully updated encounter"),
							@ApiResponse(code =404, message = "Id not found for given encounter id and branch id")	})
	@PutMapping("/encounter")
	public ResponseEntity<ResponseStructre<Encounter>> updateEncounter(@RequestBody Encounter encounter, @RequestParam int bid, @RequestParam int eid){
		return encounterService.updateEncounter(encounter, eid, bid);
		
	}
	
	
	@ApiOperation(value = "Delete encounter" , notes = "Api is used to Delete Branch with branch id")
	@ApiResponses(value = { @ApiResponse(code =200, message = "Successfully deleted encounter for given encounter id "),
							@ApiResponse(code =404, message = "Id not found for given encounter id")	})
	@DeleteMapping("/encounter")
	public ResponseEntity<ResponseStructre<Encounter>> deleteEncounter(@RequestParam int id){
		return encounterService.deleteEncounter(id);
	}
	
	
	@ApiOperation(value = "Get Encounter" , notes = "Api is used to Get Encounter with encounter id")
	@ApiResponses(value = { @ApiResponse(code =302, message = "Successfully found encounter for given encounter id "),
							@ApiResponse(code =404, message = "Id not found for given encounter id")	})
	@GetMapping("/encounter")
	public ResponseEntity<ResponseStructre<Encounter>> getEncounterById(@RequestParam int id){
		return encounterService.getEncounterById(id);
	}

}
