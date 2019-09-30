package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidaterException;
public class AdminloginValidator {
public  void validateLogin(String name, String password) throws ValidaterException {
		
		if (name == null ) {
			throw new ValidaterException("Invalid name");
		}
		if (password == null) {
			throw new ValidaterException("Invalid Password");
		}
}
}