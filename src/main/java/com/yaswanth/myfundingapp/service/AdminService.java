package com.yaswanth.myfundingapp.service;

import com.yaswanth.myfundingapp.daoimpl.AdminDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.validator.AdminValidator;

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
