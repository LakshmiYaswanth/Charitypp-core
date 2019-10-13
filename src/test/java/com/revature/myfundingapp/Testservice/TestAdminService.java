package com.revature.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.service.AdminService;


public class TestAdminService {
		@Test
		public void adminLoginTest() throws ServiceException
		{
			AdminService service=new AdminService();
			String name = "ganesh";
			String password = "raj";
			Admin admin = service.login(name,password);
			assertNotNull(admin);

}
}
