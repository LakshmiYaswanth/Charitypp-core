package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.yaswanth.myfundingapp.dao.DonorDAO;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.model.Transaction;
import com.yaswanth.myfundingapp.utility.ConnectionUtil;
import com.yaswanth.myfundingapp.utility.MessageConstant;

/**
* @author yaswanth
* This class consists of donor operations
*/   
public class DonorDAOImpl implements DonorDAO  {
	 /**
     * This  method will be shown in test case to Registeration in the application
     * @param string UserName
     * @param string Pasword
     * @param String Email
     * @parm string Age
	 * @throws DBException 
	 * @return donorObj
     */
	public Integer insert(Donor donor) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into DONOR(NAME,EMAIL,PASSWORD,AGE) values (?,?,?,?)";
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
		}
		return rows;
	}

	 /**
     * This  method will be shown in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @param StrEmail
     * @parm strAge
	 * @throws DBException 
	 * @return donorobj
     */
	public Donor login(String email, String password) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		Donor donor = null;
		try {
			
			con = ConnectionUtil.getConnection();
			String sql = "select DONOR_ID,AGE,NAME,EMAIL,PASSWORD from DONOR where EMAIL=? and PASSWORD =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				donor = new Donor();
				donor.setDonorId(rs.getInt("DONOR_ID"));
				donor.setAge(rs.getInt("AGE"));
				donor.setName(rs.getString("NAME"));
				donor.setEmail(rs.getString("EMAIL"));
				donor.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_LOGIN, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return donor;
	}
	 /**
     * This  method will be shown in test case to Donor List in the application
	 * @throws DBException
	 * @return DonorList 
     */
	public List<Donor> donorlist() throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		List<Donor> list = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT DONOR_ID,NAME,AGE,EMAIL FROM DONOR";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Donor>();
			while (rs.next()) {
				Donor donor = new Donor();
				donor.setDonorId(rs.getInt("DONOR_ID"));
				donor.setAge(rs.getInt("AGE"));
				donor.setName(rs.getString("NAME"));
				donor.setEmail(rs.getString("EMAIL"));
				list.add(donor);
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_LIST_DONOR, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return list;
	}
	 /**
     * This  method will be shown in test case to Donor List for a given name in the application
     * @param name
	 * @throws DBException
	 * @return DonorListobj
     */
	public List<Donor> donorFundinglist(String email) throws DBExeception {
		Connection con = ConnectionUtil.getConnection();
		Transaction trans = null;
		Donor donor = null;
		Request request = null;
		List<Donor> list = null;
		try {
			String smt = "select EMAIL,NAME,FUND_TYPE,AMOUNTFUNDED,FUNDED_DATE FROM DONOR d inner join TRANSACTION t on d.DONOR_ID= t.DONOR_ID inner join REQUEST r on r.REQUEST_Id= t.REQUEST_Id where EMAIL=?";
			PreparedStatement pst = con.prepareStatement(smt);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Donor>();
			while (rs.next()) {
				donor = new Donor();
				donor.setName(rs.getString("NAME"));
				donor.setEmail(rs.getString("EMAIL"));
				request = new Request();
				request.setFundType(rs.getString("FUND_TYPE"));
				donor.setRequest(request);
				trans = new Transaction();
				trans.setAmountfunded(rs.getInt("AMOUNTFUNDED"));
				donor.setTransaction(trans);
				trans.setFundedDate(rs.getDate("FUNDED_DATE"));
				donor.setTransaction(trans);
				list.add(donor);
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
		}
		return list;
	}
	public List<Donor> emailAlreadyExits(String Email) throws DBExeception{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Donor> list=null;
		 boolean row=false;
		try {
			list=new ArrayList<Donor>();
			con=ConnectionUtil.getConnection();
			String sql="Select EMAIL FROM DONOR WHERE EMAIL=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,Email);
			rs=pst.executeQuery();
			while(rs.next()) {
				 Donor donor=new Donor();
				 donor.setEmail(rs.getString("EMAIL"));
				 row=list.add(donor);
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



