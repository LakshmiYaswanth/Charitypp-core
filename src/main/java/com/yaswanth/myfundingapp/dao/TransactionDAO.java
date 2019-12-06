package com.yaswanth.myfundingapp.dao;

import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Transaction;

public interface TransactionDAO {
	
	 public int insert(Transaction trans) throws DBExeception;
	
	
}
