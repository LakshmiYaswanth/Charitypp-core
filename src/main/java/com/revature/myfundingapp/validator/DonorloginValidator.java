package com.revature.myfundingapp.validator;


import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.exceptions.ValidaterException;
import com.revature.myfundingapp.model.Donor;

public class DonorloginValidator {
	public  void ValidatorInsert(Donor donor) throws ValidaterException {
		if (donor.getName() == null) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		if (donor.getEmail() == null) {
			throw new ValidaterException(MessageConstant.INVALID_EMAIL);
		}
		if (donor.getPassword() == null) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}
		if(donor.getAge()==0) {
			throw new ValidaterException(MessageConstant.INVALID_AGE);
			
		}
	}
  public void ValidatorLogin(String name, String password) throws ValidaterException {
		
		if (name == null) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		if (password == null) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}	
}
}


