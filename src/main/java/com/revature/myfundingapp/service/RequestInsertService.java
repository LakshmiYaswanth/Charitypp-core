package com.revature.myfundingapp.service;



import com.revature.myfundingapp.dao.RequestDAOimpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.validator.RequestInsertValidator;

public class RequestInsertService {
	public Integer RequestInsert(Request request) throws ServiceException {
		Integer rows = 0;
		try {
			RequestDAOimpl requestDao=new RequestDAOimpl();
			RequestInsertValidator.ValidatorInsert(request);
			rows = requestDao.insert(request);

		} 
		catch (ValidationException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} 
		catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	}
	public Integer RequestFindByType(String fund_type) throws ServiceException{
		Request request =new Request();
		request.setFund_type(fund_type);
		int rows =0;
		try {
			
			RequestDAOimpl requestDao=new RequestDAOimpl();
			RequestInsertValidator.ValidatorInsert(request);
			rows =requestDao.insert(request);

		} catch (ValidationException e) {
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

}

