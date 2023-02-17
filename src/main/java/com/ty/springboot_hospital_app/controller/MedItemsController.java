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

import com.ty.springboot_hospital_app.dto.MedItems;
import com.ty.springboot_hospital_app.service.MedItemsService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedItemsController {
	
	@Autowired
	private MedItemsService medItemsService;
	
	
	@ApiOperation(value = "Save Meditems" , notes = "Api is used to save Meditems with medorder id ")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created meditems"),
								})
	@PostMapping("/meditems")
	public ResponseEntity<ResponseStructre<MedItems>> saveMedItems(@RequestBody MedItems medItems,@RequestParam int mid){
	return	medItemsService.saveMedItems(medItems, mid);
	}
	
	@ApiOperation(value="UpdateMedItems", notes = "api is used to update the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@PutMapping("/meditems")
	public ResponseEntity<ResponseStructre<MedItems>> updateMedItems(@RequestBody MedItems medItems,@RequestParam int mid){
	return	medItemsService.updateMedItems(medItems, mid);
	}
	
	
	@ApiOperation(value="DeleteMedItems", notes = "api is used to delete the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@DeleteMapping("/meditems")
	public ResponseEntity<ResponseStructre<MedItems>> deleteMedItems(@RequestParam int mid){
	return	medItemsService.deleteMedItems(mid);
	}
	
	@ApiOperation(value="GetMedItems", notes = "api is used to Get the MedItems for the given MedItems id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedItems Id not Found")
	})
	@GetMapping("/meditems")
	public ResponseEntity<ResponseStructre<MedItems>> getMedItems(@RequestParam int mid){
	return	medItemsService.getMedItemsById(mid);
	}
	
	
	@ApiOperation(value="GetMedItemsByMedOrder", notes = "api is used to Get the MedItems for the given MedOrder id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given MedOrder Id not Found")
	})
	@GetMapping("/meditemsgetall")
	public ResponseEntity<ResponseStructre<List<MedItems>>> getAllMedItemsByMedOrder(@RequestParam int mid){
	return	medItemsService.getAllMedItemsByMedOrder(mid);
	}

}
