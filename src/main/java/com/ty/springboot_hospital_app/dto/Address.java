package com.ty.springboot_hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@NotNull(message = "city name cannot be null")
	@NotBlank(message = "city name cannot not be Blank")
	private String city;
	
	
	@NotNull(message = "area name cannot not be null")
	@NotBlank(message = "area name cannot not be Blank")
	private String area;
	
	@NotNull(message = "street name cannot not be null")
	@NotBlank(message = "street name cannot not be Blank")
	private String street;
	
	@NotNull(message = "state name cannot not be null")
	@NotBlank(message = "state name cannot not be Blank")
	private String state;
	
	
	private int pincode;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
