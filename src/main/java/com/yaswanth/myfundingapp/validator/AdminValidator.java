package com.yaswanth.myfundingapp.validator;

import java.util.ArrayList;
import java.util.List;

import com.yaswanth.myfundingapp.daoimpl.AdminDAOImpl;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.exceptions.ValidaterException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.utility.MessageConstant;

public class AdminValidator {
        public  void validateAdmin(Admin admin) throws ValidaterException {
	     String email=admin.getEmail();
		AdminDAOImpl adminDao=new AdminDAOImpl();
		if (admin.getName() == null|| "".equals(admin.getName()) ) {
			throw new ValidaterException(MessageConstant.INVALID_NAME);
		}
		if (admin.getPassword() == null||"".equals(admin.getPassword()) ) {
			throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
		}
		List<Admin> adminObj = new ArrayList<Admin>();
		try {
		    adminObj = adminDao.emailAlreadyExits(email);
			if(adminObj == null)
			{
				throw new ValidaterException(MessageConstant.INVALID_EMAIL);
			}
		} catch (DBExeception e) {
			System.err.println("Unable to register");
		}
		
		if(email == null || "".equals(email))
		{
			throw new ValidaterException(MessageConstant.INVALID_EMAIL);
		}
}
public void validatelogin(String password,String email ) throws ValidaterException {

if (email==null||"".equals(email)) {
	throw new ValidaterException(MessageConstant.INVALID_EMAIL);
}
if (password == null||"".equals(password)) {
	throw new ValidaterException(MessageConstant.INVALID_PASSWORD);
}
}
}