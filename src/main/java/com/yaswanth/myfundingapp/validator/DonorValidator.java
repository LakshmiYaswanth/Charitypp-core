package com.yaswanth.myfundingapp.validator;

import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.utility.MessageConstant;

public class DonorValidator {
public  void ValidatorInsert(Donor donor) throws ValidaterException  {
	
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
public void ValidatorLogin(String email, String password) throws ValidaterException   {
	  
	
	if (email == null) {
		throw new ValidaterException(MessageConstant.INVALID_NAME);
	}
	if (password == null) {
		throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
	}	
}

}
