package com.yaswanth.myfundingapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yaswanth.myfundingapp.daoimpl.AdminDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Admin;

public class AdminTest {

	@Test
	public void test(){
		String name = "ganesh";
		String password = "raj";
		AdminDAOImpl appdao = new AdminDAOImpl();
		Admin admin =null;
		try {
			admin = appdao.login(name,password);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
		assertNotNull(admin);
	}}
    
