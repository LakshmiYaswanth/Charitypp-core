package com.revature.myfundingapp.dao;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.myfundingapp.daoimpl.RequestDAOimpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Request;

public class RequestTest {
	@Test
	public void TestInsert() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		Request req = new Request();
		int rows = 0;
		try {
			String fundType = "FOOD";
			Integer amount = 1000;
			LocalDate expireDate = LocalDate.parse("2019-10-19");
			Integer adminId = 1;
			req.setFundType(fundType);
			req.setAmount(amount);
			req.setAdminId(adminId);
			req.setExpireDate(expireDate);
			rows = appdao.insert(req);
			System.out.println(rows);
		} catch (DBExeception e) {
			e.printStackTrace();
		}

		assertNotNull(rows);

	}
	
	@Test
	public void Requestupdate() {
	RequestDAOimpl appdao = new RequestDAOimpl();
	try {
		Request req=new Request();
		String fundType = "FOOD";
		Integer amount = 1000000;
		LocalDate expireDate = LocalDate.parse("2019-10-19");
		Integer requestId = 5;
		req.setFundType(fundType);
		req.setAmount(amount);
		req.setRequestId(requestId);
		req.setExpireDate(expireDate);
		int rows = appdao.updateRequestlist(req);
		System.out.println(rows);
	} catch (DBExeception e) {
		e.printStackTrace();
	}
}
	@Test
	public void RequestFundList() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		  List<Request> req = null;
	      try {
	    	   req= new ArrayList<Request>();
			req = appdao.findBytype("Food");
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	      System.out.println(req); 
	}
	@Test
	public void RequestList() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		List<Request> req = new ArrayList<Request>();
	      try {
			req = appdao.list();
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	      System.out.println(req); 
	}
}
