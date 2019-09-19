package com.revature.myfundingapp.service;


import com.revature.myfundingapp.dao.UserDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidationException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.validator.DonorloginValidator;

public class DonorloginService {
	public int DonorInsert(Donor donor) throws ServiceException {
		Integer rows = null;
		try {
			UserDAOImpl fundingappDao=new UserDAOImpl ();
			DonorloginValidator.ValidatorInsert(donor);
			rows = fundingappDao.insert(donor);

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

	public Donor Validatorlogin(String name, String password) throws ServiceException {

		Donor donor = null;
			try {
				UserDAOImpl fundingappDao=new UserDAOImpl();
				DonorloginValidator.ValidatorLogin(name, password);
				donor = fundingappDao.login1(name, password);

			} catch (ValidationException e) {
				System.out.println("Exception:" + e.getMessage());
				e.printStackTrace();
				throw new ServiceException(e.getMessage(), e);
			} catch (DBExeception e) {
				System.out.println("Exception:" + e.getMessage());
				e.printStackTrace();
				throw new ServiceException(e.getMessage(), e);
			}
			return donor;
		}
	
	}


