package com.yaswanth.myfundingapp.Testservice;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
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
		RequestService Service = new RequestService();
		Request req=new Request();
		req.setFundType(Fund_type);
		req.setAmount(Amount);
		req.setAdminId(Admin_Id);
		req.setExpireDate(Expire_date);
		Integer Isinserted=0;
		try {
			 Isinserted = Service.requestInsert(req);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(Isinserted);
		}
	
	public void RequestUpdate() {
		String Fund_type = "Food";
		Integer Amount = 1100;
		LocalDate Expire_date = LocalDate.parse("2019-10-19");
		Integer RequestId = 1;
		RequestService service = new RequestService();
		Request req=new Request();
		req.setFundType(Fund_type);
		req.setAmount(Amount);
		req.setRequestId(RequestId);
		req.setExpireDate(Expire_date);
		try {
			int rows = service.RequestUpdate(req);
			System.out.println(rows);
		} catch (ServiceException e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void TestfindByvalue()  {
		RequestService service = new RequestService();
		List<Request> req = null;
		req = service.FundType("food");
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
}
	
