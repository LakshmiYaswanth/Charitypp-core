package com.yaswanth.myfundingapp.dao;

import java.util.List;

import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Admin;

public interface AdminDAO {
	public Admin login(String name, String password) throws DBExeception;
	public Integer adminRegister(Admin admin) throws DBExeception;
	public List<Admin> emailAlreadyExits(String email) throws DBExeception;
}
