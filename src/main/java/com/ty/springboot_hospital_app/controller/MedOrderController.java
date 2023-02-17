package com.ty.springboot_hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.MedOrder;
import com.ty.springboot_hospital_app.service.MedOrderService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {
	
	@Autowired
	private MedOrderService service;
	
	
	@ApiOperation(value = "Save Medorder" , notes = "Api is used to save Medorder with encounter id ")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created medorder"),
							@ApiResponse(code= 404, message="Given Encounter Id not Found")
								})
	@PostMapping("/medorder")
	public ResponseEntity<ResponseStructre<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder,@RequestParam int eid){
		return service.saveMedOrder(medOrder, eid);
	}
	
	
	
	@ApiOperation(value="UpdateMedOrder", notes = "api is used to update the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@PutMapping("/medorder")
	public ResponseEntity<ResponseStructre<MedOrder>> updateMedOrder(@RequestBody MedOrder medOrder,@RequestParam int mid){
		return service.updateMedOrder(medOrder, mid);
	}
	
	
	@ApiOperation(value="DeleteMedOrder", notes = "api is used to delete the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@DeleteMapping("/medorder")
	public ResponseEntity<ResponseStructre<MedOrder>> deleteMedOrder(@RequestParam int mid){
		return service.deleteMedOrder(mid);
	}
	
	
	@ApiOperation(value="GetMedOrder", notes = "api is used to Get the MedOrder for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@GetMapping("/medorder")
	public ResponseEntity<ResponseStructre<MedOrder>> getMedOrder(@RequestParam int mid){
		return service.getMedOrder(mid);
	}
	
	
	@ApiOperation(value="GetMedOrderByEncounter", notes = "api is used to Get the MedOrder for the given Encounter id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given encounter Id not Found")
	})
	@GetMapping("/medordergetall")
	public ResponseEntity<ResponseStructre<List<MedOrder>>> getAllMedOrderById(@RequestParam int eid){
		return service.getAllMedOrderByEncounter(eid);
	}

}
