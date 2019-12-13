package com.yaswanth.myfundingapp.model;

public class Donor {
	private Integer donorId;
	private String name;
	private Integer age; 
	private String email;
	private String password;
	private Request request;
	private RequestType requesttype;
	public RequestType getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(RequestType requesttype) {
		this.requesttype = requesttype;
	}
	private Transaction transaction;
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
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + ", request=" + request + ", requesttype=" + requesttype + ", transaction=" + transaction
				+ "]";
	}
	
}