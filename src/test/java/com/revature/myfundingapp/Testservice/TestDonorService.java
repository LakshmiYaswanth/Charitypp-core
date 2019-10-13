package com.revature.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;


public class TestDonorService {
	@Test
	public void DonorLoginTest() throws ServiceException
	{
		DonorService service=new DonorService();
		String name = "yaswanth";
		String password = "yaswanth";
		Donor donor=null;
		donor = service.login(name,password);
		assertNotNull(donor);
		
	}
	@Test
	public void testRegister() throws DBExeception, ServiceException {
		String name = "yaswanth";
		Integer age = 21;
		String email = "yaswanth@123";
		String password = "IloveU";
		DonorService service=new DonorService();
         Donor donor= new Donor();
		donor.setName(name);
		donor.setAge(age);
		donor.setEmail(email);
		donor.setPassword(password);
		Integer rows = service.donorInsert(donor);
		System.out.println(rows);		
}
	@Test
	public void Donorlist(){
		DonorService service=new DonorService();
        List<Donor> list=null;
        try {
			list=service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
        assertNotNull(list);	
	}
	@Test
	public void Donorfundinglist() throws DBExeception{
		DonorService service=new DonorService();
        List<Donor> donor= new ArrayList<Donor>();
        donor = service.fundingList("yaswanth");
        assertNotNull(donor);	
	}

}
