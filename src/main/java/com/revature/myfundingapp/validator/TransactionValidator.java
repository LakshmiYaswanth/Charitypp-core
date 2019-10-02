package com.revature.myfundingapp.validator;

import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Transaction;
public class TransactionValidator{
	public void ValidatorInsert(Transaction trans) throws ValidaterException {
	
		if (trans.getDonorId() == 0) {
			throw new ValidaterException(MessageConstant.INVALID_ID);
		}
		if (trans.getRequestId() == 0) {
			throw new ValidaterException(MessageConstant.INVALID_ID);
		}
		if (trans.getTransactionId() == 0) {
			throw new ValidaterException(MessageConstant.INVALID_ID);
		}
		if (trans.getAmountfunded()>= 0) {
			throw new ValidaterException(MessageConstant.UNABLE_TO_FUND_AMOUNT);
		}
	}}
	
	


