package com.revature.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorloginService;

public class TestDonorService {
	@Test
	public void DonorLoginTest() throws ServiceException
	{
		DonorloginService service=new DonorloginService();
		String name = "yaswanth";
		String password = "yaswanth";
		Donor donor=null;
		try {
			donor = service.login(name,password);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
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
	public void Donorlist(){
		DonorloginService service=new DonorloginService();
        List<Donor> list=null;
        try {
			list=service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
        assertNotNull(list);	
	}

}
