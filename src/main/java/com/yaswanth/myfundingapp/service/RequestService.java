package com.yaswanth.myfundingapp.service;

import java.util.List;

import com.yaswanth.myfundingapp.daoimpl.DonorDAOImpl;
import com.yaswanth.myfundingapp.daoimpl.RequestDAOimpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.validator.DonorValidator;
import com.yaswanth.myfundingapp.validator.RequestValidator;

public class RequestService {
	/*  insert the fund request  where we have to give  inputs */  
	public Integer requestInsert(Request request) throws ServiceException {
		Integer rows = 0;
		try {
			RequestDAOimpl requestDao = new RequestDAOimpl();
			RequestValidator requestobj = new RequestValidator();
			requestobj.ValidatorInsert(request);
			rows = requestDao.insert(request);
		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	}
	/* list request where we have to give  inputs */  
	public List<Request> FundType(String fundtype) {
		RequestDAOimpl requestDao = new RequestDAOimpl();
			List<Request> list = null;
				try {
					list = requestDao.findBytype(fundtype);
				} catch (DBExeception e) {
					e.printStackTrace();
				}
		return list;
	}
	/* Update request where we have to give inputs */  
	public Integer RequestUpdate(Request request) throws ServiceException {
		Integer rows = 0;
		try {
			RequestDAOimpl requestDao = new RequestDAOimpl();
			RequestValidator Request = new RequestValidator();
			Request.ValidatorInsert(request);
			rows = requestDao.updateRequestlist(request);
		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	
}
	/* Fund request list where we have to give inputs */  
	public List<Request> list() throws ServiceException {
		List<Request> req  = null;
		try {
			RequestDAOimpl request=new RequestDAOimpl();
			req = request.list();
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return req;
	}
	public List<Request> Fundtypelist() throws ServiceException {
		List<Request> req  = null;
		try {
			RequestDAOimpl request=new RequestDAOimpl();
			req = request.selectFundType();
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return req;
	}
	public int status(int requestId) throws ServiceException {
		Integer rows = null;
		try {
		
			RequestDAOimpl fundingappDao=new RequestDAOimpl ();
			rows = fundingappDao.StatusCheck(requestId);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
		
	}
	
}
