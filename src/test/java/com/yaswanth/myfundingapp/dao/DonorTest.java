package com.yaswanth.myfundingapp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yaswanth.myfundingapp.daoimpl.DonorDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Donor;




public class DonorTest {
	@Test
	public void test() throws DBExeception {
		String email = "yaswanth23@gmail.com";
		String password = "yasw13";
		DonorDAOImpl appdao = new DonorDAOImpl();
		Donor donor = appdao.login(email, password);
		System.out.println(donor);
		assertNotNull(donor);
	}
@Test
	public void testRegister() throws DBExeception {
		String name = "rajesh";
		Integer age = 21;
		String email = "rajesh2@gmail.com";
		String password = "rajesh";
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
      assertNotNull(donor);    
}	
@Test
public void fundingList() throws DBExeception{
	DonorDAOImpl appdao = new DonorDAOImpl();
	List<Donor> donor = new ArrayList<Donor>();
      try {
		donor = appdao.donorFundinglist("ram@gmail.com");
	} catch (DBExeception e) {
		e.printStackTrace();
	}
      assertNotNull(donor);	
}
@Test
public void testEmail() throws DBExeception{
	String email="yaswanth@12gmail.com";
	DonorDAOImpl appdao = new DonorDAOImpl();
	Donor donor=new Donor();
	donor.setEmail(email);
	List<Donor> rows = appdao.emailAlreadyExits(email);
	assertNotNull(rows);
	
}
	
}

