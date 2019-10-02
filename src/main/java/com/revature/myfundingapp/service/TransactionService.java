package com.revature.myfundingapp.service;


import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Transaction;
import com.revature.myfundingapp.validator.TransactionValidator;

public class TransactionService {
	/* Insert Transaction where we have to give inputs */  
	public int  transactionInsert( int amountfunded,int Request_id,int Donor_Id) throws ServiceException {
		Transaction trans = new Transaction();
		trans.setDonorId(Donor_Id);
		trans.setAmountfunded(amountfunded);
		trans.setTransactionId(Request_id);
		int rows;
		try {
			rows=0;
			TransactionDAOImpl transDao=new TransactionDAOImpl();
			TransactionValidator validator = new TransactionValidator();
			validator.ValidatorInsert(trans);
			 rows=transDao.insert(trans);
		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	return (rows);
	}
	
}