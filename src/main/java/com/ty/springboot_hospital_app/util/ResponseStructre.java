package com.ty.springboot_hospital_app.util;

public class ResponseStructre<T> {
	
	private String meesage;
	private int status;
	private T data;
	
	public String getMeesage() {
		return meesage;
	}
	public void setMeesage(String meesage) {
		this.meesage = meesage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
