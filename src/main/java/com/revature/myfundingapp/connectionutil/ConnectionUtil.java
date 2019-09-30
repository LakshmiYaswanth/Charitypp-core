package com.revature.myfundingapp.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.myfundingapp.exceptions.DBExeception;

 public class ConnectionUtil {
	public static Connection getConnection() throws DBExeception {

		String url = "jdbc:mysql://trainingdb.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/yaswanth_db";
		String password = "yaswanth";
		String username = "yaswanth";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
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
		}
		catch (Exception e) {
			System.out.println("unable to close");
		}
	}
	}



