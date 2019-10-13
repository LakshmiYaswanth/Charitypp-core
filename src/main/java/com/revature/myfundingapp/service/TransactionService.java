package com.revature.myfundingapp.service;


import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Transaction;

public class TransactionService { 
	public int  insertservice(Transaction transaction) throws ServiceException {
		Integer rows = 0;
		try {
			TransactionDAOImpl transDao=new TransactionDAOImpl();
			 rows=transDao.insert(transaction);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
	return (rows);
	}
	
}