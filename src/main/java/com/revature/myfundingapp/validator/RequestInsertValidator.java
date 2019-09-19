package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Request;

public class RequestInsertValidator {
	public static void ValidatorInsert(Request request) throws ValidationException {

		if (request.getFund_type() == null) {
			throw new ValidationException("Invalid Fund_type");
		
	
	}

}}
