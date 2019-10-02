package com.revature.myfundingapp.connectionutil;

public final class Logger {
	public static final String level = "DEBUG";
	public static final String level1="ERROR";
	public static final String level2="INFO";

	public static void debug(Object message) {
		if (level == "DEBUG") {
			System.out.println(message);
		}
	}
	public static void error(Object message) {
		if (level1 == "ERROR") {
			System.out.println(message);
		}
	}
	public static void info(Object message) {
		if (level2 == "INFO") {
			System.out.println(message);
		}
	}
}
