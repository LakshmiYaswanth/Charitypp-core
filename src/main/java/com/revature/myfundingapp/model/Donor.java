package com.revature.myfundingapp.model;

public class Donor {
	private Integer donorId;
	private String name;
	private Integer age; 
	private String email;
	private String password;
	private Boolean isloggedIn;
	private Boolean isallreadyExists;
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer donorId) {
		this.donorId = donorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsallreadyExists() {
		return isallreadyExists;
	}
	public void setIsallreadyExists(Boolean isallreadyExists) {
		this.isallreadyExists = isallreadyExists;
	}
	public Boolean getIsloggedIn() {
		return isloggedIn;
	}
	public void setIsloggedIn(Boolean isloggedIn) {
		this.isloggedIn=isloggedIn;
	}
}