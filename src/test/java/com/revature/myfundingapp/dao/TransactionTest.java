package com.revature.myfundingapp.dao;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Transaction;

public class TransactionTest {
	
@Test
	public void TestInsert() {
	TransactionDAOImpl transaction =new TransactionDAOImpl();
      Transaction trans = new Transaction();
	int Isinserted = 0;
	try {
		Integer AmountFunded = 300;
		Integer requestId = 1;
		Integer donorId = 1;
		trans.setRequestId(requestId);
	    trans.setAmountfunded(AmountFunded);
		trans.setDonorId(donorId);
		Isinserted = transaction.insert(trans);
		System.out.println(Isinserted);
	} catch (DBExeception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(Isinserted);
}
	
	}

