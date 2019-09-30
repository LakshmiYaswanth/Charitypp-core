package com.revature.myfundingapp.validator;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Request;
public class RequestValidator {
	public  void ValidatorInsert(Request request) throws ValidaterException {

		if (request.getFundType() == null) {
			throw new ValidaterException("Invalid Fundtype");
		}
		if(request.getAmount()<=0) {
			throw new ValidaterException("Invalid Amount");
		}
		
}}
