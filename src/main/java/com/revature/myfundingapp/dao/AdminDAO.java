package com.revature.myfundingapp.dao;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;

public interface AdminDAO {
	public Admin login(String name, String password) throws DBExeception;
}
