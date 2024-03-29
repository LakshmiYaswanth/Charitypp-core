package com.yaswanth.myfundingapp.utility;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Baseclass {
	public static Logger logger = Logger.getLogger(Baseclass.class);
	private static Properties prop;
	/**
	 * This function is to read properties file
	 *
	 * @return properties
	 */
	public static Properties getProperties() {
		try {
			InputStream input = Baseclass.class.getResourceAsStream("/configuration.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException ex) {
			logger.error("Unable to get data from properties file");
		}
		return prop;
	}

}
