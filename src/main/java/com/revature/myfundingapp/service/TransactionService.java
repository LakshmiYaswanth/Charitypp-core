package com.revature.myfundingapp.service;

import java.util.List;

import com.revature.myfundingapp.daoimpl.DonorDAOImpl;
import com.revature.myfundingapp.daoimpl.RequestDAOimpl;
import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.model.Transaction;
import com.revature.myfundingapp.validator.TransactionValidator;

public class TransactionService {
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
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	return (rows);
	}
	
}