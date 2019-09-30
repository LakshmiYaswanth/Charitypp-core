package com.revature.myfundingapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.myfundingapp.daoimpl.AdminDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;
public class logintest {

	@Test
	public void test() throws DBExeception {
		String name = "ganesh";
		String password = "raj";
		AdminDAOImpl appdao = new AdminDAOImpl();
		Admin admin = appdao.login(name,password);
		assertNotNull(admin);
	}}
    
