package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.log4j.Logger;

import com.yaswanth.myfundingapp.dao.AdminDAO;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.utility.ConnectionUtil;
import com.yaswanth.myfundingapp.utility.MessageConstant;


 
/**
 * @author yaswanth
 * This class consists of admin login 
 *
 */
public class AdminDAOImpl implements AdminDAO{
	Logger logger = Logger.getLogger("AdminDAOImpl.class");
	 /**
     * This  method will be shown in test case to login in the application
     * @param string UserName
     * @param string Password
	 * @throws DBException 
     */
	public Admin login(String name,String password) throws DBExeception  {
		Connection con=null;
		PreparedStatement pst =null;
		Admin admin=null;
		ResultSet rs=null;
		try {
			
			con=ConnectionUtil.getConnection();
			String sql="select ADMIN_ID,NAME,PASSWORD From ADMIN where NAME = ? and PASSWORD = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,password);
			 rs=pst.executeQuery();
			if(rs.next()) {
				admin=new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setPassword(rs.getString("PASSWORD"));
				logger.info("login was Successfull");
			}}
	          catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_LOGIN,e);
			} finally {
			    ConnectionUtil.close(con, pst,rs);
			}
			return admin;
	}
	
}
