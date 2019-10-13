package com.revature.myfundingapp.service;



import java.util.ArrayList;
import java.util.List;

import com.revature.myfundingapp.daoimpl.DonorDAOImpl;
import com.revature.myfundingapp.daoimpl.RequestDAOimpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.validator.DonorValidator;
import com.revature.myfundingapp.validator.RequestValidator;
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
	public Donor login(String name, String password) throws ServiceException {

		Donor donor = null;
			try {
				DonorValidator donorValidator= new DonorValidator();
				DonorDAOImpl fundingappDao=new DonorDAOImpl();
				donorValidator.ValidatorLogin(name,password);
				donor = fundingappDao.login(name, password);

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
		DonorDAOImpl Dao = new DonorDAOImpl();
		list = Dao.donorFundinglist(name);
		return list;
	}
}

