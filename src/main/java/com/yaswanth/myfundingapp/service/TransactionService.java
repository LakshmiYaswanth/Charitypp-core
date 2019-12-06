package com.yaswanth.myfundingapp.service;

import com.yaswanth.myfundingapp.daoimpl.TransactionDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Transaction;

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