package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Transaction;
public class TransactionValidator{
	public void ValidatorInsert(Transaction trans) throws ValidaterException {
	
		if (trans.getDonorId() == 0) {
			throw new ValidaterException("Invalid id");
		}
		if (trans.getRequestId() == 0) {
			throw new ValidaterException("Invalid type");
		}
		if (trans.getTransactionId() == 0) {
			throw new ValidaterException("Invalid Password");
		}
		if (trans.getAmountfunded()>= 0) {
			throw new ValidaterException("invalid active");
		}
	}}
	
	


