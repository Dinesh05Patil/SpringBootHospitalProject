package com.ty.springboot_hospital_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.exception.DeleteBranchIdNotFound;
import com.ty.springboot_hospital_app.exception.UpdateBranchIdNotFound;
import com.ty.springboot_hospital_app.service.BranchService;
import com.ty.springboot_hospital_app.util.ResponseStructre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	
	
	@ApiOperation(value = "Save Branch" , notes = "Api is used to save Branch with Hospital id")
	@ApiResponses(value = { @ApiResponse(code =201, message = "Successfully created branch"),
							@ApiResponse(code =404, message = "Id not found for given Hospital id")	})
						
	@PostMapping("/branch/{hid}/{aid}")
	public ResponseEntity<ResponseStructre<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable int hid,
			@PathVariable int aid) {
		return branchService.saveBranch(branch, hid, aid);
	}
	
	@ApiOperation(value = "Update Branch" , notes = "Api is used to update Branch with branch id")
	@ApiResponses(value = { @ApiResponse(code =200, message = "Successfully updated branch"),
							@ApiResponse(code =404, message = "Id not found for given branch id")	})
	
	@PutMapping("/branch")
	public ResponseEntity<ResponseStructre<Branch>> updateBranch(@RequestParam int id, @RequestBody Branch branch) throws UpdateBranchIdNotFound {
		return branchService.updateBranch(branch, id);
	}
	
	@ApiOperation(value = "Get Branch" , notes = "Api is used to Get Branch with branch id")
	@ApiResponses(value = { @ApiResponse(code =302, message = "Successfully found branch for given branch id "),
							@ApiResponse(code =404, message = "Id not found for given branch id")	})
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<ResponseStructre<Branch>> getBranch(@PathVariable int id) {
		return branchService.getBranch(id);
	}
	
	@ApiOperation(value = "Delete Branch" , notes = "Api is used to Delete Branch with branch id")
	@ApiResponses(value = { @ApiResponse(code =200, message = "Successfully deleted branch for given branch id "),
							@ApiResponse(code =404, message = "Id not found for given branch id")	})

	@DeleteMapping("/branch/{id}")
	public ResponseEntity<ResponseStructre<Branch>> deleteBranch(@PathVariable int id) throws DeleteBranchIdNotFound {
		return branchService.deleteBranch(id);
	}
	
	@ApiOperation(value = "Delete Branch" , notes = "Api is used to Get Branch for given hospital id")
	@ApiResponses(value = { @ApiResponse(code =302, message = "Successfully found branch for given hospital id "),
							@ApiResponse(code =404, message = "Id not found for given branch id")	})

	@GetMapping("/branch1/{hid}")
	public ResponseEntity<ResponseStructre<List<Branch>>> getBranchByHospitalId(@PathVariable int hid) {
		return branchService.getBranchByHospitalId(hid);
	}

	
	
	@GetMapping("/getallbranch")
	public ResponseEntity<ResponseStructre<List<Branch>>> getAllBranch(@RequestParam int hid){
		return branchService.getBranchByHospitalId(hid);
	}

}
