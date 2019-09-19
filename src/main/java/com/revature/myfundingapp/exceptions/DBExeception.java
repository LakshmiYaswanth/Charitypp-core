package com.revature.myfundingapp.exceptions;

@SuppressWarnings("serial")
public class DBExeception extends Exception{

	public DBExeception(String message, Throwable throwable) {
		super(message,throwable);
	}
}
 