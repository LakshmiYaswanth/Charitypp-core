package com.yaswanth.myfundingapp.dao;

import java.util.List;

import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Donor;



public interface DonorDAO {

	public Integer insert(Donor donor) throws DBExeception;
	public Donor login(String email,String password) throws DBExeception; 
	public List<Donor> donorlist() throws DBExeception;
	public List<Donor> donorFundinglist(String email) throws DBExeception;
	public List<Donor> emailAlreadyExits(String Email) throws DBExeception;
	
}
