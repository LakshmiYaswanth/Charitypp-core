package com.revature.myfundingapp.service;

import java.util.ArrayList;
import java.util.List;
import com.revature.myfundingapp.dao.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidationException;

import com.revature.myfundingapp.model.Transaction;
import com.revature.myfundingapp.validator.TransactionValidator;

public class TransactionService {
	public void  TransactionInsert( int amountfunded,int transaction_id) throws ServiceException {

		Transaction trans = new Transaction();
		trans.setAmountfunded(amountfunded);
		trans.setTransaction_id(transaction_id);
		try {
			TransactionDAOImpl transDao=new TransactionDAOImpl();
			TransactionValidator.ValidatorInsert(trans);
			transDao.insert(trans);

		} catch (ValidationException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
	}
//	public void  RequestListInsert(String fund_type,int target_Amount,int fundrasied, int fundpending) throws ServiceException {
//		Requestlist list = new Requestlist();
//		list.setFundType(fund_type);
//		list.setTarget_Amount(target_Amount);
//		list.setFundraised(fundrasied);
//		list.setFundpending(fundpending);
//		try {
//			TransactionDAOImpl transDao=new TransactionDAOImpl();
//			TransactionValidator.validatorInsert1(list);
//			transDao.listFundRequest(fund_type);
//
//		} catch (ValidationException e) {
//			System.out.println("Exception:" + e.getMessage());
//			e.printStackTrace();
//			throw new ServiceException(e.getMessage(), e);
//		} catch (DBExeception e) {
//			System.out.println("Exception:" + e.getMessage());
//			e.printStackTrace();
//			throw new ServiceException(e.getMessage(), e);
//		}
//	}
	
		}

