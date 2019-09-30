package com.revature.myfundingapp.model;

public class Admin {
	private Integer adminId;
	private String name;
	private String password;
	private Boolean isLoggedin;
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsLoggedin() {
		return isLoggedin;
	}
	public void setIsLoggedin(Boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
}

	