package com.ty.springboot_hospital_app.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class MedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	private Date date;
	
	@NotNull(message = "doctor name cannot not be null")
	@NotBlank(message = "doctor name cannot not be Blank")
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;

}
