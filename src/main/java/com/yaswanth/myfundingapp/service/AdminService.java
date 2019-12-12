package com.yaswanth.myfundingapp.service;

import com.yaswanth.myfundingapp.daoimpl.AdminDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.validator.AdminValidator;

  
public class AdminService {
	public Admin login(String email, String password) throws ServiceException {
		AdminDAOImpl appDao = new AdminDAOImpl();
		Admin admin = null;
		try {
			AdminValidator adminloginValidator = new AdminValidator();
			adminloginValidator.validatelogin(password, email);
			admin = appDao.login(email, password);
			if ( admin == null) {
				throw new ServiceException("Invalid Login");
			}
		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return admin;
	}
	public int adminInsert(Admin admin) throws ServiceException {
		Integer rows = null;
		try {
			AdminValidator adminValidator= new AdminValidator();
			AdminDAOImpl fundingappDao=new AdminDAOImpl ();
			adminValidator.validateAdmin(admin);
			rows = fundingappDao.adminRegister(admin);

		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
		
	}
}
