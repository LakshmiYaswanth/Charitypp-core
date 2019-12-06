package com.yaswanth.myfundingapp.validator;

import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.utility.MessageConstant;

public class AdminValidator {
public  void validateLogin(String name, String password) throws ValidaterException {
		
		if (name == null ) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		if (password == null) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}
}
}