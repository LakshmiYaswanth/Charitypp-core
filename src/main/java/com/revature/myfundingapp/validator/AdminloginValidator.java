package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.exceptions.ValidaterException;
public class AdminloginValidator {
public  void validateLogin(String name, String password) throws ValidaterException {
		
		if (name == null ) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		if (password == null) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}
}
}