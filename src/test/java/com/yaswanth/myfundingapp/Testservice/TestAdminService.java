package com.yaswanth.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.service.AdminService;




public class TestAdminService {
		@Test
		public void adminLoginTest() throws ServiceException
		{
			AdminService service=new AdminService();
			String email = "ramu@gmail.com";
			String password = "ramu123";
			Admin admin = service.login(email,password);
			assertNotNull(admin);
}
		@Test 
		public void adminRegisterTest() throws ServiceException{
			AdminService service=new AdminService();
			String name="ramu";
			String email="ramu123@gmail.com";
			String password="ramu123";
			Admin admin =new Admin();
			admin.setName(name);
			admin.setEmail(email);
			admin.setPassword(password);
			int row=service.adminInsert(admin);
			assertNotNull(row);
		}
}
