package com.revature.myfundingapp.service;



import java.util.List;

import com.revature.myfundingapp.daoimpl.DonorDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.validator.DonorloginValidator;

public class DonorloginService {
	public int DonorInsert(Donor donor) throws ServiceException {
		Integer rows = null;
		try {
			DonorloginValidator donorValidator= new DonorloginValidator();
			DonorDAOImpl fundingappDao=new DonorDAOImpl ();
			donorValidator.ValidatorInsert(donor);
			rows = fundingappDao.insert(donor);

		} catch (ValidaterException e) {
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

	public Donor login(String name, String password) throws ServiceException, DBExeception {

		Donor donor = null;
			try {
				DonorloginValidator donorValidator= new DonorloginValidator();
				DonorDAOImpl fundingappDao=new DonorDAOImpl();
				donorValidator.ValidatorLogin(name,password);
				donor = fundingappDao.login(name, password);

			} catch (ValidaterException e) {
				System.out.println("Exception:" + e.getMessage());
				e.printStackTrace();
				throw new ServiceException(e.getMessage(), e);
			} catch(DBExeception e)
			{
				throw new DBExeception(e.getMessage(),e);
			}
			return donor;
		}
	public List<Donor> list() throws ServiceException {
		List<Donor> list = null;
		try {
			DonorDAOImpl donor=new DonorDAOImpl();
			list = donor.donorlist();
		} catch (DBExeception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(), e);
		}
		return list;
	}
	}


