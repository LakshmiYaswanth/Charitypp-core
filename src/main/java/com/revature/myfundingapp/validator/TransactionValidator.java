package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Request;

import com.revature.myfundingapp.model.Transaction;

public class TransactionValidator{
	public static void ValidatorInsert(Transaction trans) throws ValidationException {
	
		if (trans.getId() == 0) {
			throw new ValidationException("Invalid id");
		}
		if (trans.getDonor_id() == 0) {
			throw new ValidationException("Invalid Fund_type");
		}
		if (trans.getTransaction_id() == 0) {
			throw new ValidationException("Invalid Password");
		}
		if (trans.getAmountfunded() == 0) {
			throw new ValidationException("invalid active");
		}

	}
	
	}
	


