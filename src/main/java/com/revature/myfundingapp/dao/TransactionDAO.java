package com.revature.myfundingapp.dao;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Transaction;

public interface TransactionDAO {
	
	 public int insert(Transaction trans) throws DBExeception;
	
}
