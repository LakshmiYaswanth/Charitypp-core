package com.revature.myfundingapp.dao;

import java.util.List;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Transaction;

public interface TransactionDAO {
	 public int insert(Transaction trans) throws DBExeception;
	// public List<Requestlist> listFundRequest(String FundType) throws DBExeception;  	  
}
