package com.revature.myfundingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.model.Donor;
public class UserDAOImpl implements UserDAO {
	public Admin login(String name,String password) throws DBExeception  {
		Connection con=null;
		PreparedStatement pst =null;
		Admin admin=null;
		try {
			admin=new Admin();
			con=ConnectionUtil.getConnection();
			String sql="select admin_id,name,password From admin where name = ? and password = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString (2,password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setIsloggedin(true);
			}
			else
			{
				admin.setIsloggedin(false);	
			}
			} catch (SQLException e) {
				throw new DBExeception("Unable to login admin", e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			}
			return admin;
		
	}
	
	
	public int insert(Donor donor) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into Donor(name,email,password,age) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, donor.getName());
			pst.setString(2, donor.getEmail());
			pst.setString(3, donor.getPassword());
			pst.setInt(4, donor.getAge());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception("Unable to insert user", e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		} return rows;
	}
	
	
	public Donor login1(String name ,String password) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		Donor donor = null;
	    Boolean Isloggedin=false;
		try {
			donor = new Donor();
			con = ConnectionUtil.getConnection();
			String sql = "select donor_id,age,name,email,password from Donor where name=? and password =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				donor.setDonor_id(rs.getInt("donor_id"));
				donor.setAge(rs.getInt("age"));
				donor.setName(rs.getString("name"));
				donor.setEmail(rs.getString("email"));
				donor.setPassword(rs.getString("password"));
				Isloggedin = true;
			}
			
			
		} catch (SQLException e) {
			throw new DBExeception("Unable to login donor", e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return donor;
	}
}
