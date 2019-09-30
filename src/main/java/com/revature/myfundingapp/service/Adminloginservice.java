package com.revature.myfundingapp.service;


import com.revature.myfundingapp.daoimpl.AdminDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.validator.AdminloginValidator;

public class Adminloginservice {
	public Admin login(String name, String password) throws ServiceException {
      AdminDAOImpl appDao=new AdminDAOImpl();
		Admin admin = null;
		try {
			AdminloginValidator adminloginValidator= new AdminloginValidator();
			adminloginValidator.validateLogin(name, password);
			admin = appDao.login(name, password);

		} catch (ValidaterException e) {
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
