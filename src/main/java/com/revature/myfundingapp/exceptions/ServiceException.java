package com.revature.myfundingapp.exceptions;


public class ServiceException extends Exception{
	private static final long serialVersionUID = 3816050857608790251L;
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String message, Throwable e) {
		super(message,e);
	}
}


