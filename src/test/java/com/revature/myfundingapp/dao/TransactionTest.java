package com.revature.myfundingapp.dao;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;

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
		Integer Id = 1;
		Integer donor_Id = 3;
		trans.setId(Id);
	    trans.setAmountfunded(AmountFunded);
		trans.setDonor_id(donor_Id);
		Isinserted = transaction.insert(trans);
		System.out.println(Isinserted);
	} catch (DBExeception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(Isinserted);
}
	
	}

