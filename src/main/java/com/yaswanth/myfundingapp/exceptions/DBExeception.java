package com.yaswanth.myfundingapp.exceptions;


public class DBExeception extends Exception{
	private static final long serialVersionUID = 1L;

	public DBExeception(String message, Throwable throwable) {
		super(message,throwable);
	}
}
 