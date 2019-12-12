package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
	 /**
     * This  method will be shown in test case to login in the application
     * @param string UserName
     * @param string Password
	 * @throws DBException 
     */
	public Admin login(String email,String password) throws DBExeception  {
		Connection con=null;
		PreparedStatement pst =null;
		Admin admin=null;
		ResultSet rs=null;
		try {
			
			con=ConnectionUtil.getConnection();
			String sql="select ADMIN_ID,NAME,EMAIL,PASSWORD From ADMIN where EMAIL = ? and PASSWORD = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2,password);
			 rs=pst.executeQuery();
			if(rs.next()) {
				admin=new Admin();
				admin.setAdminId(rs.getInt("ADMIN_ID"));
				admin.setName(rs.getString("NAME"));
				admin.setEmail(rs.getString("EMAIL"));
				admin.setPassword(rs.getString("PASSWORD"));
			}}
	          catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_LOGIN,e);
			} finally {
			    ConnectionUtil.close(con, pst,rs);
			}
			return admin;
	}
	public Integer adminRegister(Admin admin) throws DBExeception {
		Connection con=null;
		PreparedStatement pst=null;
		int rows=0;
		try{
			con=ConnectionUtil.getConnection();
			String sql="INSERT INTO ADMIN (NAME,EMAIL,PASSWORD ) VALUES (?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,admin.getName());
			pst.setString(2, admin.getEmail());
			pst.setString(3, admin.getPassword());
			rows=pst.executeUpdate();
			}
			catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_REGISTER, e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			}
			return rows;
		}
	public List<Admin> emailAlreadyExits(String email) throws DBExeception{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Admin> list=null;
		 boolean row=false;
		try {
			list=new ArrayList<Admin>();
			con=ConnectionUtil.getConnection();
			String sql="Select EMAIL FROM ADMIN WHERE EMAIL=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,email);
			rs=pst.executeQuery();
			while(rs.next()) {
				 Admin admin=new Admin();
				 admin.setEmail(rs.getString("EMAIL"));
				 row=list.add(admin);
				 if(row==true) {
					 System.out.println("Email already Exits");
				 } 
			}}
        catch (SQLException e) {
			throw new DBExeception(MessageConstant.INVALID_EMAIL,e);
		} finally {
		    ConnectionUtil.close(con, pst,rs);
		}
		return list;
	}
		}
		
	
		