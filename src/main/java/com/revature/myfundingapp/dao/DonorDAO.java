package com.revature.myfundingapp.dao;

import java.util.List;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;

public interface DonorDAO {

	public Integer insert(Donor donor) throws DBExeception;
	public Donor login(String name,String password) throws DBExeception; 
	public List<Donor> donorlist() throws DBExeception;
	public List<Donor> donorFundinglist(String name) throws DBExeception;
	
}
