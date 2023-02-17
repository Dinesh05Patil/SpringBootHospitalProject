package com.ty.springboot_hospital_app.exception;

public class DeleteBranchIdNotFound extends Exception {
	
private String message="id doesnot exist to delete";
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeleteBranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	public DeleteBranchIdNotFound( ) {
		
	}

}
