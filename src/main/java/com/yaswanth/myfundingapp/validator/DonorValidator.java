package com.yaswanth.myfundingapp.validator;

import java.util.ArrayList;
import java.util.List;

import com.yaswanth.myfundingapp.daoimpl.DonorDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.utility.MessageConstant;

public class DonorValidator {
public  void ValidatorInsert(Donor donor) throws ValidaterException  {
	      String email=donor.getEmail();
		if (donor.getName() == null|| "".equals(donor.getName())) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		DonorDAOImpl donorDao=new DonorDAOImpl();
		List<Donor> donorObj = new ArrayList<Donor>();
		try {
		    donorObj = donorDao.emailAlreadyExits(email);
			if(donorObj == null)
			{
				throw new ValidaterException(MessageConstant.INVALID_EMAIL);
			}
		} catch (DBExeception e) {
			System.err.println("Unable to register");
		}
		
		if(email == null || "".equals(email))
		{
			throw new ValidaterException(MessageConstant.INVALID_EMAIL);
		}
		if (donor.getPassword() == null|| "".equals(donor.getPassword())) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}
		if(donor.getAge()==0) {
			throw new ValidaterException(MessageConstant.INVALID_AGE);	
		
		}

	}
public void ValidatorLogin(String email, String password) throws ValidaterException   {
	  
	
	if (email == null|| "".equals(email)) {
		throw new ValidaterException(MessageConstant.INVALID_NAME);
	}
	if (password == null|| "".equals(password)) {
		throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
	}	
}

}
