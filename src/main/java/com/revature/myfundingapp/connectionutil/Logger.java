package com.revature.myfundingapp.connectionutil;

public final class Logger {
public static final String level = "DEBUG";
	
	public  void debug(Object message)
	{
		if(level == "DEBUG")
		{
			System.out.println(message);
		}
	}
	
	public  void error(Object message)
	{
		if(level == "ERROR")
		{
			System.out.println(message);
		}
	}
	
	public  void info(Object message)
	{		if(level == "INFO")
		{
			System.out.println(message);
		}
	}

}

