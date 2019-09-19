package com.revature.myfundingapp.dao;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Request;

public class RequestTest {
	@Test
	public void TestInsert() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		Request req = new Request();
		int rows = 0;
		try {
			String Fund_type = "food";
			Integer Amount = 1000;
			LocalDate Expire_date = LocalDate.parse("2019-10-19");
			Integer Admin_Id = 1;
			req.setFund_type(Fund_type);
			req.setAmount(Amount);
			req.setAdmin_id(Admin_Id);
			
			req.setExpire_date(Expire_date);
			rows = appdao.insert(req);
			System.out.println(rows);
		} catch (DBExeception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(rows);

	}
	@Test
	public void TestfindByvalue() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		Request req = new Request();
	      req = appdao.findBytype("food");
	      System.out.println(req);    
}
			

		
	}

