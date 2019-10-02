package com.revature.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.dao.AdminDAO;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;
  /* Admin login where we have to give only valid inputs */  
public class AdminDAOImpl implements AdminDAO{
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
				admin.setIsLoggedin(true);
			}
			else
			{
				admin.setIsLoggedin(false);	
			}
			} catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_LOGIN,e);
			} finally {
				ConnectionUtil.close(con, pst,rs);
			}
			return admin;
		
	}
	

}
