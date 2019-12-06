package com.yaswanth.myfundingapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public class ConnectionUtil {
	
	public static Properties properties = Baseclass.getProperties();
	public final static String URL = properties.getProperty("url");
	public final static String PASSWORD = properties.getProperty("password");
	public final static String USERNAME = properties.getProperty("username");
	public final static String DRIVER=properties.getProperty("driver");

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException("Unable to get DB Connection" + e);
		}
		return con;
	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs) {

		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		} finally {

		}
	}
}

