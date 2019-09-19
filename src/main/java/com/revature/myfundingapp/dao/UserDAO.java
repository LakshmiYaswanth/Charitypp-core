package com.revature.myfundingapp.dao;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.model.Donor;

public interface UserDAO {
	public Admin login(String name,String password) throws DBExeception;
	public int insert(Donor donor) throws DBExeception;
	public Donor login1(String name,String password) throws DBExeception; 
}
