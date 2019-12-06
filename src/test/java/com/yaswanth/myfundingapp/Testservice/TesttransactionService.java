package com.yaswanth.myfundingapp.Testservice;


import org.junit.Test;

import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Transaction;
import com.yaswanth.myfundingapp.service.TransactionService;


public class TesttransactionService {
	@Test
	public void testRequest() {
		Integer amountfunded = 1000;
		Integer donorId = 1;
		Integer requestId=1;
         TransactionService service = new TransactionService();
		Transaction trans =new Transaction();
		trans.setAmountfunded(amountfunded);
		trans.setDonorId(donorId);
	    trans.setRequestId(requestId);
		Integer Isinserted=0;
		try {
			 Isinserted = service.insertservice(trans);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(Isinserted);
		}
	

}
