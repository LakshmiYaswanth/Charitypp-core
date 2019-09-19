package com.revature.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.Adminloginservice;
import com.revature.myfundingapp.service.DonorloginService;
import com.revature.myfundingapp.service.RequestInsertService;


public class Loginservice {
	@Test
	public void adminLoginTest() throws ServiceException
	{
		Adminloginservice service=new Adminloginservice();
		String name = "yaswanth";
		String password = "iloveu";
		Admin admin = service.login(name,password);
		System.out.println(admin);
		assertNotNull(admin);
		
	}
	@Test
	public void DonorLoginTest() throws ServiceException
	{
		DonorloginService service=new DonorloginService();
		String name = "yaswanth";
		String password = "iloveu";
		Donor donor = service.Validatorlogin(name,password);
		System.out.println(donor);
		assertNotNull(donor);
		
	}
	@Test
	public void testRegister() throws DBExeception, ServiceException {
		String name = "yaswanth";
		Integer age = 21;
		String email = "yaswanth@123";
		String password = "IloveU";
		DonorloginService service=new DonorloginService();
         Donor donor= new Donor();
		donor.setName(name);
		donor.setAge(age);
		donor.setEmail(email);
		donor.setPassword(password);
		Integer rows = service.DonorInsert(donor);
		System.out.println(rows);		
}
	@Test
	public void testRequest() throws ServiceException {
		String Fund_type = "Food";
		Integer Amount = 1000;
		LocalDate Expire_date = LocalDate.parse("2019-10-19");
		Integer Admin_Id = 1;
		RequestInsertService Service = new RequestInsertService();
		Request req=new Request();
		req.setFund_type(Fund_type);
		req.setAmount(Amount);
		req.setAdmin_id(Admin_Id);
		req.setExpire_date(Expire_date);
		Integer  Isinserted = Service.RequestInsert(req);
        System.out.println(Isinserted);
	}
}
	
