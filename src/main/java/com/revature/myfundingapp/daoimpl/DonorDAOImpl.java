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
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.model.Transaction;
/*Donor register where we have to give only valid inputs*/   
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
	/* Donor login where we have to give only valid inputs */  
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
	       public List<Donor> donorFundinglist(String name) throws DBExeception{
	    	   Connection con = ConnectionUtil.getConnection();
	   		 Transaction trans = null;
	   	     Donor donor=null;
            Request request= null;
	   		List<Donor> list = null;
	   		try {
	   			String smt="select NAME,FUND_TYPE,AMOUNTFUNDED FROM DONOR d inner join TRANSACTION t on d.DONOR_ID= t.DONOR_ID inner join REQUEST r on r.REQUEST_Id= t.REQUEST_Id where NAME= ?" ; 
	   			PreparedStatement pst = con.prepareStatement(smt);
	   			pst.setString(1,name);
				ResultSet rs = pst.executeQuery();
				list = new ArrayList<Donor>();
				while (rs.next()) {
				
					donor = new Donor();
					donor.setName(rs.getString("NAME"));
					request = new Request();
					request.setFundType(rs.getString("FUND_TYPE"));
					donor.setRequest(request);
					trans = new Transaction();
					trans.setAmountfunded(rs.getInt("AMOUNTFUNDED"));
					donor.setTransaction(trans);
					list.add(donor);
				}
			} catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
			}
			return list;	
	       }
	}




