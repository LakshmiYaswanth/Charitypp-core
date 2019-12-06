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


  /* Admin login where we have to give only valid inputs */  
public class AdminDAOImpl implements AdminDAO{
	Logger logger = Logger.getLogger("AdminDAOImpl.class");
	public Admin login(String name,String password) throws DBExeception  {
		Connection con=null;
		PreparedStatement pst =null;
		Admin admin=null;
		ResultSet rs=null;
		try {
			admin=new Admin();
			con=ConnectionUtil.getConnection();
			String sql="select ADMIN_ID,NAME,PASSWORD From ADMIN where NAME = ? and PASSWORD = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString (2,password);
			ResultSet rs1=pst.executeQuery();
			if(rs1.next()) {
				admin.setAdminId(rs1.getInt("ADMIN_ID"));
				admin.setName(rs1.getString("NAME"));
				admin.setPassword(rs1.getString("PASSWORD"));
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
