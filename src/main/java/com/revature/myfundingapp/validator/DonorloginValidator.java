package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Donor;

public class DonorloginValidator {
	public static void ValidatorInsert(Donor donor) throws ValidationException {
		if (donor.getName() == null) {
			throw new ValidationException("Invalid Name");
		}
		if (donor.getEmail() == null) {
			throw new ValidationException("Invalid Email");
		}
		if (donor.getPassword() == null) {
			throw new ValidationException("Invalid Password");
		}
		if(donor.getAge()==0) {
			throw new ValidationException("invalid age");
			
		}
	}
public static void ValidatorLogin(String name, String password) throws ValidationException {
		
		if (name == null || name==" ") {
			throw new ValidationException("Invalid Email");
		}
		if (password == null || name==" ") {
			throw new ValidationException("Invalid Password");
		}	
}
}


