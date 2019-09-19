package com.revature.myfundingapp.exceptions;

@SuppressWarnings("serial")
public class ServiceException extends Exception{
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String message, Throwable e) {
		super(message,e);
	}
}


