package com.yaswanth.myfundingapp.service;



import java.util.ArrayList;
import java.util.List;

import com.yaswanth.myfundingapp.daoimpl.DonorDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.validator.DonorValidator;

/* Donor Register where we have to give  inputs */  
public class DonorService {
	public int donorInsert(Donor donor) throws ServiceException {
		Integer rows = null;
		try {
			DonorValidator donorValidator= new DonorValidator();
			DonorDAOImpl fundingappDao=new DonorDAOImpl ();
			donorValidator.ValidatorInsert(donor);
			rows = fundingappDao.insert(donor);

		} catch (ValidaterException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
		
	}
	/* Donor login where we have to give only valid inputs */  
	public Donor login(String email, String password) throws ServiceException {

		Donor donor = null;
			try {
				DonorValidator donorValidator= new DonorValidator();
				DonorDAOImpl fundingappDao=new DonorDAOImpl();
				donorValidator.ValidatorLogin(email,password);
				donor = fundingappDao.login(email, password);

			} catch (ValidaterException e) {
				throw new ServiceException(e.getMessage(), e);
			} catch(DBExeception e)
			{
				throw new ServiceException(e.getMessage(),e);
			}
			return donor;
		}
	
	/* List of all Donor */  
	public List<Donor> list() throws ServiceException {
		List<Donor> list = null;
		try {
			DonorDAOImpl donor=new DonorDAOImpl();
			list = donor.donorlist();
		} catch (DBExeception e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return list;
	}
	public List<Donor> fundingList(String name) throws DBExeception {
		List<Donor> list = null;
		list = new ArrayList<Donor>();
		DonorDAOImpl donor = new DonorDAOImpl();
		list = donor.donorFundinglist(name);
		return list;
	}
}


