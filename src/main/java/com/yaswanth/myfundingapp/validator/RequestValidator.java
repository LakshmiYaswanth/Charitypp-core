package com.yaswanth.myfundingapp.validator;

import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Request;

public class RequestValidator {
	public  void ValidatorInsert(Request request) throws ValidaterException  {
		if (request.getFundTypeId() == null) {
			throw new ValidaterException("Invalid Fund_type");
		}	
	}	
}



