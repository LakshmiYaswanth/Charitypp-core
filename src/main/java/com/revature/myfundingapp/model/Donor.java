package com.revature.myfundingapp.model;

public class Donor {
	private Integer donor_id;
	private String name;
	private Integer age; 
	private String email;
	private String password;
	public Integer getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(Integer donor_id) {
		this.donor_id = donor_id;
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
	@Override
	public String toString() {
		return "Donor [donor_id=" + donor_id + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + "]";
	}
}
