package com.revature.myfundingapp.model;

public class Admin {
	private Integer admin_id;
	private String name;
	private String password;
	private Boolean isloggedin;
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
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
	public Boolean getIsloggedin() {
		return isloggedin;
	}
	public void setIsloggedin(Boolean isloggedin) {
		this.isloggedin = isloggedin;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", name=" + name + ", password=" + password + ", isloggedin="
				+ isloggedin + "]";
	}
}
