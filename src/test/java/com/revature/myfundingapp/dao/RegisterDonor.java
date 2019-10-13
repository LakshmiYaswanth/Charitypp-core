package com.revature.myfundingapp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.myfundingapp.daoimpl.DonorDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;


public class RegisterDonor {
	@Test
	public void test() throws DBExeception {
		String name = "yaswanth";
		String password = "yaswanth";
		DonorDAOImpl appdao = new DonorDAOImpl();
		Donor donor = appdao.login(name, password);
		System.out.println(donor);
		assertNotNull(donor);
	}
@Test
	public void testRegister() throws DBExeception {
		String name = "yaswanth";
		Integer age = 21;
		String email = "yaswanth@123";
		String password = "yaswanth";
		DonorDAOImpl appdao = new DonorDAOImpl();
		Donor donor = new Donor();
		donor.setName(name);
		donor.setAge(age);
		donor.setEmail(email);
		donor.setPassword(password);
		int rows = appdao.insert(donor);
		System.out.println(rows);
		assertNotNull(rows);

	}
@Test
  public void list()throws DBExeception{
	DonorDAOImpl appdao = new DonorDAOImpl();
	List<Donor> donor = new ArrayList<Donor>();
      try {
		donor = appdao.donorlist();
	} catch (DBExeception e) {
		e.printStackTrace();
	}
      System.out.println(donor);    
}	
@Test
public void fundinglist() throws DBExeception{
	DonorDAOImpl appdao = new DonorDAOImpl();
	List<Donor> donor = new ArrayList<Donor>();
      try {
		donor = appdao.donorFundinglist("rakesh");
	} catch (DBExeception e) {
		e.printStackTrace();
	}
      System.out.println(donor);
	
}
	
}

