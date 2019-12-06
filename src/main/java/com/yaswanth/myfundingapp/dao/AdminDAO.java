package com.yaswanth.myfundingapp.dao;

import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Admin;

public interface AdminDAO {
	public Admin login(String name, String password) throws DBExeception;
}
