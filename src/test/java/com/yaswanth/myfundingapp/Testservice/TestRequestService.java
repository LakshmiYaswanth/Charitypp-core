package com.yaswanth.myfundingapp.Testservice;


import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.service.RequestService;



public class TestRequestService {
	@Test
	public void testRequest() {
		String Fund_type = "Food";
		Integer Amount = 1000;
		LocalDate Expire_date = LocalDate.parse("2019-10-19");
		Integer Admin_Id = 1;
		String description="FOOD FOR CYCLONE AFFECTED AREAS";
		RequestService Service = new RequestService();
		Request req=new Request();
		req.setFundType(Fund_type);
		req.setAmount(Amount);
		req.setAdminId(Admin_Id);
		req.setExpireDate(Expire_date);
		req.setDescription(description);
		Integer Isinserted=0;
		try {
			 Isinserted = Service.requestInsert(req);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(Isinserted);
		}
	
	public void RequestUpdate() {
		String Fund_type = "Food";
		Integer Amount = 1100;
		LocalDate Expire_date = LocalDate.parse("2019-10-19");
		String description="FOOD FOR CYCLONE AFFECTED AREAS";
		Integer RequestId = 1;
		RequestService service = new RequestService();
		Request req=new Request();
		req.setFundType(Fund_type);
		req.setAmount(Amount);
		req.setDescription(description);
		req.setRequestId(RequestId);
		req.setExpireDate(Expire_date);
		int rows=0;
		try {
			rows = service.RequestUpdate(req);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(rows);	
	}
	@Test
	public void TestfindByvalue() {
		RequestService service = new RequestService();
		  List<Request> req= new ArrayList<Request>();
		req = service.FundType("Food");
		assertNotNull(req); 
	}
	@Test
	public void Requestlist(){
		RequestService service=new RequestService();
        List<Request> request=null;
        try {
			request=service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
        assertNotNull(request);	
	}
	@Test
	public void RequesFundtlist(){
		RequestService service=new RequestService();
        List<Request> request=null;
        try {
			request=service.Fundtypelist();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
        assertNotNull(request);	
	}
	@Test
	public void Requeststatus() {
		RequestService service=new RequestService();
		Integer row=0;
	      try {
			row= service.status(4);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	      assertNotNull(row);
	      System.out.println(row);
	}
}
	
