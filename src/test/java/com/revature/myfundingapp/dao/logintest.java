package com.revature.myfundingapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;
public class logintest {

	@Test
	public void test() throws DBExeception {
		String name = "ganesh";
		String password = "raj";
		UserDAOImpl appdao = new UserDAOImpl();
		Admin admin = appdao.login(name,password);
		System.out.println(admin);
		assertNotNull(admin);
	}}
    
