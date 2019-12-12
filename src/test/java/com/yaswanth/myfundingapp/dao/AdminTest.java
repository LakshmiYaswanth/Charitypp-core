package com.yaswanth.myfundingapp.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yaswanth.myfundingapp.daoimpl.AdminDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Admin;


public class AdminTest {

	@Test
	public void test(){
		String email = "ramu@gmail.com";
		String password = "ramu123";
		AdminDAOImpl appdao = new AdminDAOImpl();
		Admin admin =null;
		try {
			admin = appdao.login(email,password);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
		assertNotNull(admin);
	}
	@Test
	public void testRegister() throws DBExeception {
		String name = "yaswanth";
		String email = "yaswanth1@gmail.com";
		String password = "yasw13";
		AdminDAOImpl appdao = new AdminDAOImpl();
		Admin admin=new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		int rows = appdao.adminRegister(admin);
		assertNotNull(rows);
	}
	@Test
	public void testEmail() throws DBExeception{
		String email="yaswanth123@gmail.com";
		AdminDAOImpl appdao = new AdminDAOImpl();
		Admin admin=new Admin();
		admin.setEmail(email);
		List<Admin> rows = appdao.emailAlreadyExits(email);
		assertNotNull(rows);
		
	}
	}
    
