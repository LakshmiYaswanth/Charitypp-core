package com.revature.myfundingapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;

public class RegisterDonor {
	@Test
	public void test() throws DBExeception {
		String name = "RAJ";
		String password = "IloveU";
		UserDAO appdao = new UserDAOImpl();
		Donor donor = appdao.login1(name, password);
		System.out.println(donor);
		assertNotNull(donor);
	}
@Test
	public void testRegister() throws DBExeception {
		String name = "yaswanth";
		Integer age = 21;
		String email = "yaswanth@123";
		String password = "IloveU";
		UserDAO appdao = new UserDAOImpl();
		Donor donor = new Donor();
		donor.setName(name);
		donor.setAge(age);
		donor.setEmail(email);
		donor.setPassword(password);
		int rows = appdao.insert(donor);
		System.out.println(rows);
		assertNotNull(rows);

	}

}
