package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidationException;

public class AdminloginValidator {
	

	
public static void validateLogin(String name, String password) throws ValidationException {
		
		if (name == null || name==" ") {
			throw new ValidationException("Invalid name");
		}
		if (password == null || name==" ") {
			throw new ValidationException("Invalid Password");
		}
}
}