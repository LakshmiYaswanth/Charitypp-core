package com.revature.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.dao.DonorDAO;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;

public class DonorDAOImpl implements DonorDAO  {
	public Integer insert(Donor donor) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into DONOR(NAME,EMAIL,PASSWORD,AGE) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, donor.getName());
			pst.setString(2, donor.getEmail());
			pst.setString(3, donor.getPassword());
			pst.setInt(4, donor.getAge());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_REGISTER, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		} return rows;
	}
	public void isalreadyResister(String name) throws DBExeception{
		Connection con=null;
		PreparedStatement pst =null;
		Donor donor=null;
		try {
			
			con=ConnectionUtil.getConnection();
			String sql="select NAME From DONOR where name = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1,name);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				donor=new Donor();
				donor.setIsallreadyExists(true);
			}
			else
			{
				donor.setIsallreadyExists(false);	
			}
			} catch (SQLException e) {
				throw new DBExeception(MessageConstant.EMAIL_ALREADY_EXIST, e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			}
		
	}

	public Donor login(String name ,String password) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		Donor donor = null;
	    try {
			donor = new Donor();
			con = ConnectionUtil.getConnection();
			String sql = "select DONOR_ID,AGE,NAME,EMAIL,PASSWORD from DONOR where NAME=? and PASSWORD =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				donor.setDonorId(rs.getInt("DONOR_ID"));
				donor.setAge(rs.getInt("AGE"));
				donor.setName(rs.getString("NAME"));
				donor.setEmail(rs.getString("EMAIL"));
				donor.setPassword(rs.getString("PASSWORD"));
				donor.setIsloggedIn(true);
			}
			else
			{
				donor.setIsloggedIn(false);	
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_LOGIN, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return donor;
	}
	public List<Donor> donorlist() throws DBExeception{
		Connection con=null;
		PreparedStatement pst=null;
		List<Donor> list=null;
		try {
			con=ConnectionUtil.getConnection();
			String sql="SELECT DONOR_ID,NAME,AGE,EMAIL FROM DONOR";
			pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			list = new ArrayList<Donor>();
			 
		  while(rs.next()) {
			    Donor donor = new Donor();
				donor.setDonorId(rs.getInt("DONOR_ID"));
				donor.setAge(rs.getInt("AGE"));
				donor.setName(rs.getString("NAME"));
				donor.setEmail(rs.getString("EMAIL"));
				list.add(donor);
			}
		}
		  catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_LIST_DONOR, e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			}
			return list;
		}
}



