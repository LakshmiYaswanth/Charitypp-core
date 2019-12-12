package com.yaswanth.myfundingapp.dao;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yaswanth.myfundingapp.daoimpl.RequestDAOimpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Request;



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
			String description="FOOD FOR CYCLONE AFFECTED AREAS";
			req.setFundType(fundType);
			req.setAmount(amount);
			req.setAdminId(adminId);
			req.setExpireDate(expireDate);
			req.setDescription(description);
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
	int rows =0;
	try {
		Request req=new Request();
		String fundType = "FOOD";
		String description="FOOD FOR CYCLONE AFFECTED AREAS";
		Integer amount = 100;
		LocalDate expireDate = LocalDate.parse("2019-10-19");
		Integer requestId =1;
		req.setFundType(fundType);
		req.setAmount(amount);
		req.setDescription(description);
		req.setRequestId(requestId);
		req.setExpireDate(expireDate);
		rows=appdao.updateRequestlist(req);
	} catch (DBExeception e) {
		e.printStackTrace();
	}
	assertNotNull(rows);
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
	      assertNotNull(req); 
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
	      assertNotNull(req); 
	}
	@Test
	public void RequestFundTypeList() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		List<Request> req = new ArrayList<Request>();
	      try {
			req = appdao.selectFundType();
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	      assertNotNull(req); 
	}
	@Test
	public void RequestStatus() {
		RequestDAOimpl appdao = new RequestDAOimpl();
		Integer row=0;
	      try {
			row= appdao.StatusCheck(2);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
	      assertNotNull(row);
	      System.out.println(row);
	}
		
	}

