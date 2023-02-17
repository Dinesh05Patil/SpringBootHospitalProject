package com.ty.springboot_hospital_app.exception;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospital_app.util.ResponseStructre;

@ControllerAdvice
public class ApplicationExceptionalHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructre<String>> idNotFoundExceptionHandler(IdNotFoundException ex){
		ResponseStructre<String> structre=new ResponseStructre<String>();
		structre.setMeesage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no Hospital for given id");
		return new ResponseEntity<ResponseStructre<String>>(structre,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructre<String>> noSuchElementExceptionHandler(NoSuchElementException ex){
		ResponseStructre<String> structre=new ResponseStructre<String>();
		structre.setMeesage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no Hospital for given id");
		return new ResponseEntity<ResponseStructre<String>>(structre,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UpdateBranchIdNotFound.class)
	public ResponseEntity<ResponseStructre<String>> updateBranchIdNotFound(UpdateBranchIdNotFound ex){
		
		ResponseStructre<String> structre=new ResponseStructre<String>();
		structre.setMeesage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no branch for given id");
		return new ResponseEntity<ResponseStructre<String>>(structre,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DeleteBranchIdNotFound.class)
	public ResponseEntity<ResponseStructre<String>> deleteBranchIdNotFound (DeleteBranchIdNotFound ex){
		ResponseStructre<String> structre=new ResponseStructre<String>();
		structre.setMeesage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no branch exist for given id ");
		return new ResponseEntity<ResponseStructre<String>>(structre,HttpStatus.NOT_FOUND);
		
	}
	

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> error=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<>();
		for(ObjectError er: error) {
			String fieldName= ((FieldError)er).getField();
			String message = ((FieldError)er).getDefaultMessage();
			
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constrainVoilationException(ConstraintViolationException con){
		List<String> list=new ArrayList<>();
		Set<ConstraintViolation<?>> set=con.getConstraintViolations();
		for(ConstraintViolation<?> violation:set) {

			String name=violation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list,HttpStatus.BAD_REQUEST);
		
		
	}
	

}
