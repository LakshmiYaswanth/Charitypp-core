package com.revature.myfundingapp.validator;


import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Donor;

public class DonorloginValidator {
	public  void ValidatorInsert(Donor donor) throws ValidaterException {
		if (donor.getName() == null) {
			throw new ValidaterException("Invalid Name");
		}
		if (donor.getEmail() == null) {
			throw new ValidaterException("Invalid Email");
		}
		if (donor.getPassword() == null) {
			throw new ValidaterException("Invalid Password");
		}
		if(donor.getAge()==0) {
			throw new ValidaterException("invalid age");
			
		}
	}
  public void ValidatorLogin(String name, String password) throws ValidaterException {
		
		if (name == null) {
			throw new ValidaterException("Invalid Email");
		}
		if (password == null) {
			throw new ValidaterException("Invalid Password");
		}	
}
}


