package com.ty.springboot_hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.BranchDao;
import com.ty.springboot_hospital_app.dto.Branch;
import com.ty.springboot_hospital_app.exception.DeleteBranchIdNotFound;
import com.ty.springboot_hospital_app.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.exception.UpdateBranchIdNotFound;
import com.ty.springboot_hospital_app.util.ResponseStructre;

@Service
public class BranchService {
	
	@Autowired
	private BranchDao dao;
	
	public ResponseEntity<ResponseStructre<Branch>> saveBranch(Branch branch,int hid,int aid){
		ResponseStructre<Branch> responseStructre=new ResponseStructre<Branch>();
		responseStructre.setMeesage("successfully saved branch");
		responseStructre.setStatus(HttpStatus.CREATED.value());
		responseStructre.setData(dao.saveBranch(branch, hid, aid));
		
		return new ResponseEntity<ResponseStructre<Branch>>(responseStructre,HttpStatus.CREATED);
	}
		
	
public ResponseEntity<ResponseStructre<Branch>> updateBranch(Branch branch, int id) throws UpdateBranchIdNotFound{
		
		Branch daoBranch=dao.updateBranch(id, branch);
		if(daoBranch!=null) {
			ResponseStructre<Branch> responseStructure=new ResponseStructre<>();
			responseStructure.setMeesage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoBranch);
			return new ResponseEntity<ResponseStructre<Branch>>(responseStructure, HttpStatus.OK);
		}else {
			throw new UpdateBranchIdNotFound();
		}
		
	}
	
	
	public ResponseEntity<ResponseStructre<Branch>> deleteBranch(int id) throws DeleteBranchIdNotFound{
		Branch branch=dao.deleteBranch(id);
		if(branch!=null) {
			ResponseStructre<Branch> structre=new ResponseStructre<Branch>();
			structre.setMeesage("successfully deleted branch");
			structre.setStatus(HttpStatus.OK.value());
			structre.setData(branch);
			
			return new ResponseEntity<ResponseStructre<Branch>>(structre,HttpStatus.OK);
		}else {
			throw new DeleteBranchIdNotFound();
		}
	}
	
	
	public ResponseEntity<ResponseStructre<Branch>> getBranch(int id){
		ResponseStructre<Branch> structre=new ResponseStructre<Branch>();
		Branch branch=dao.getBranchById(id);
		if(branch!=null) {
			structre.setMeesage("successfully found branch");
			structre.setStatus(HttpStatus.FOUND.value());
			structre.setData(branch);
			
			return new ResponseEntity<ResponseStructre<Branch>>(structre,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("Id not found for given branch");
		}
		
	}


	public ResponseEntity<ResponseStructre<List<Branch>>> getBranchByHospitalId(int hid) {
		List<Branch> daoBranch=dao.getBranchByHospitalId(hid);
		if(daoBranch!=null) {
		ResponseStructre<List<Branch>> structre=new ResponseStructre<List<Branch>>();
		structre.setMeesage("found successfully");
		structre.setStatus(HttpStatus.FOUND.value());
		structre.setData(daoBranch);
		return new ResponseEntity<ResponseStructre<List<Branch>>>(structre,HttpStatus.FOUND);
	}else {
		throw new IdNotFoundException("Id not found for given hospital");
	}
	}

}
