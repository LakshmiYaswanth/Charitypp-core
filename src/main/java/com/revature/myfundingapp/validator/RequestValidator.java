package com.revature.myfundingapp.validator;
import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Request;
public class RequestValidator {
	public  void ValidatorInsert(Request request) throws ValidaterException {

		if (request.getFundType() == null) {
			throw new ValidaterException(MessageConstant.INVALID_FUND_TYPE);
		}
		if(request.getAmount()<=0) {
			throw new ValidaterException(MessageConstant.UNABLE_TO_FUND_AMOUNT);
		}
		
}}
