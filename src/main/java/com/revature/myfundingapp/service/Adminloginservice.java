package com.revature.myfundingapp.service;


import com.revature.myfundingapp.dao.UserDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.validator.AdminloginValidator;

public class Adminloginservice {
	public Admin login(String name, String password) throws ServiceException {
      UserDAOImpl appDao=new UserDAOImpl();
		Admin admin = null;
		try {
			AdminloginValidator.validateLogin(name, password);
			admin = appDao.login(name, password);

		} catch (ValidationException e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			System.out.println("Exception:" + e.getMessage());
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return admin;
	}		
}
