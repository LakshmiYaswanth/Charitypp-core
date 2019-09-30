package com.revature.myfundingapp.service;

import java.util.List;
import com.revature.myfundingapp.daoimpl.RequestDAOimpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.validator.RequestValidator;

public class RequestService {
	public Integer RequestInsert(Request request) throws ServiceException {
		Integer rows = 0;
		try {
			RequestDAOimpl requestDao = new RequestDAOimpl();
			RequestValidator Request = new RequestValidator();
			Request.ValidatorInsert(request);
			rows = requestDao.insert(request);
		} catch (ValidaterException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	}

	public List<Request> FundType(String fundtype) throws ServiceException, DBExeception {
		Request request = new Request();
		List<Request> list = null;

		try {
			RequestDAOimpl requestDao = new RequestDAOimpl();
			list = requestDao.findBytype(fundtype);
			RequestValidator Request = new RequestValidator();
			Request.ValidatorInsert(request);
		} catch (ValidaterException e) {
			System.out.println("Exception:" + e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}
		return list;
	}
	public Integer RequestUpdate(Request request) throws ServiceException {
		Integer rows = 0;
		try {
			RequestDAOimpl requestDao = new RequestDAOimpl();
			RequestValidator Request = new RequestValidator();
			Request.ValidatorInsert(request);
			rows = requestDao.updateRequestlist(request);
		} catch (ValidaterException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	
}
	public List<Request> list() throws ServiceException {
		List<Request> req  = null;
		try {
			RequestDAOimpl request=new RequestDAOimpl();
			req = request.list();
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return req;
	}
}
