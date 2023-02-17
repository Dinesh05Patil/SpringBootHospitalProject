package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@NotNull(message = "Person name cannot not be null")
	@NotBlank(message = "Person name cannot not be Blank")
	private String name;
	
	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be Blank")
	private String email;
	
	
	private long phone;

}
