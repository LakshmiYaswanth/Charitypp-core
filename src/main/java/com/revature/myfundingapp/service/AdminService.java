package com.revature.myfundingapp.service;

import com.revature.myfundingapp.daoimpl.AdminDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.validator.AdminValidator;

/* Admin login where we have to give inputs */  
public class AdminService {
	public Admin login(String name, String password) throws ServiceException {
		AdminDAOImpl appDao = new AdminDAOImpl();
		Admin admin = null;
		try {
			AdminValidator adminloginValidator = new AdminValidator();
			adminloginValidator.validateLogin(name, password);
			admin = appDao.login(name, password);
		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return admin;
	}
}
