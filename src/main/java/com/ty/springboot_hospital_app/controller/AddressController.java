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

import com.ty.springboot_hospital_app.dto.Address;
import com.ty.springboot_hospital_app.service.AddressService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	
	@ApiOperation(value = "Save Address" , notes = "Api is used to save Address")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created address"),
							})
	@PostMapping("/address")
	public ResponseEntity<ResponseStructre<Address>> saveAddress(@RequestBody Address address){
		return service.saveAddress(address);
	}
	
	
	@ApiOperation(value="Update Address", notes = "api is used to update the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully updated"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@PutMapping("/address")
	public ResponseEntity<ResponseStructre<Address>> updateAddress(@RequestParam int id,@RequestBody Address address){
		return service.updateAddress(id,address);
	}
	
	
	@ApiOperation(value="Delete Address", notes = "api is used to delete the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully deleted"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@DeleteMapping("/address")
	public ResponseEntity<ResponseStructre<Address>> deleteAddress(@RequestParam int id){
		return service.deleteAddress(id);
	}
	
	@ApiOperation(value="GetAddress", notes = "api is used to Get the address for the given address id")
	@ApiResponses(value= {
			@ApiResponse(code = 302, message = "Successfully Fetched"),
			@ApiResponse(code= 404, message="Given address Id not Found")
	})
	@GetMapping("/address")
	public ResponseEntity<ResponseStructre<Address>> getAddressById(@RequestParam int id){
		return service.getAddressById(id);
	}
}
