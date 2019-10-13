package com.revature.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Request;

public class RequestDAOimpl {
	/* Request insert where we have to give only valid inputs */  
	public int insert(Request request) throws DBExeception{
			Connection con = null;
			PreparedStatement pst = null;
			int Isinserted = 0;
			try {
				con = ConnectionUtil.getConnection();
				String sql="INSERT INTO REQUEST (FUND_TYPE,AMOUNT,EXPIRE_DATE,ADMIN_ID) values(?,?,?,?) ";
				pst=con.prepareStatement(sql);
				Date Expire_Date = Date.valueOf(request.getExpireDate());
				pst.setString(1, request.getFundType());
				pst.setInt(2, request.getAmount());
			    pst.setDate(3, Expire_Date);
				pst.setInt(4, request.getAdminId());
				 if(pst.executeUpdate() == 1)
					{
						Isinserted = 1;
					}
			} catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_INSERT, e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			} return Isinserted;
	}
	/* Request to row*/  
	public Request toRow(ResultSet rs) {
		Connection con=null;
		PreparedStatement pst=null;
		Request request=null;
		try {
            Integer requestId=rs.getInt("REQUEST_ID");
			String fundType = rs.getString("FUND_TYPE");
			Integer amount = rs.getInt("Target_Amount");
			Date expireDate=rs.getDate("EXPIRE_DATE");
			Date announcedDate=rs.getDate("ANNOUNCED_DATE");
			Integer amountneeded=rs.getInt("AMOUNT_NEEDED");
		    request= new Request();
			request.setRequestId(requestId);
			request.setExpireDate(expireDate.toLocalDate());
			request.setFundType(fundType);
			request.setAmount(amount);
			request.setAnnouncedDate(announcedDate.toLocalDate());
			request.setAmountneeded(amountneeded);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return request;
	}
	/* List fund type where we have to give only valid inputs */  
	public List<Request> findBytype(String fundType)throws DBExeception {
		Connection con = ConnectionUtil.getConnection();
		Request request = null;
		List<Request> list = null;
		try {
			list =new ArrayList<Request>();
			String sqlStmt="Select REQUEST_Id,ANNOUNCED_DATE,FUND_TYPE,EXPIRE_DATE,AMOUNT as Target_Amount,(AMOUNT-(select ifnull(sum(AMOUNTFUNDED),0) from TRANSACTION where REQUEST_Id =r.REQUEST_Id)) as AMOUNT_NEEDED,EXPIRE_DATE FROM REQUEST r where FUND_TYPE = ? AND EXPIRE_DATE >= NOW() and AMOUNT > IFNULL((select sum(AMOUNTFUNDED) from TRANSACTION whereTRANSACTION where AMOUNTFUNDED BETWEEN 0 and AMOUNT AND REQUEST_Id=r.REQUEST_Id),0)"; ;
					
			PreparedStatement pst = con.prepareStatement(sqlStmt);
			pst.setString(1,fundType);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				request = toRow(rs);
				list.add(request);
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
		}
		return list;
	}
	/* update request list where we have to give only valid inputs */
	public int updateRequestlist(Request request) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int IsUpdated=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "UPDATE REQUEST SET FUND_TYPE=?, AMOUNT=?,EXPIRE_DATE=? WHERE  REQUEST_Id=?";
			pst = con.prepareStatement(sql);
			Date Expire_Date = Date.valueOf(request.getExpireDate());
			pst.setString(1, request.getFundType());
			pst.setInt(2, request.getAmount());
		    pst.setDate(3, Expire_Date);
			pst.setInt(4, request.getRequestId());
			IsUpdated = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_UPDATE, e);
		} finally {
			ConnectionUtil.close(con, pst,null);	
		}
		return IsUpdated;		
	}
	/* request List*/  
 public List<Request> list() throws DBExeception{
	 Connection con =null;
	 PreparedStatement pst =null;
	 List<Request> list=null;
	 try {
			con=ConnectionUtil.getConnection();
			String sql="SELECT REQUEST_Id,FUND_TYPE,AMOUNT,EXPIRE_DATE from REQUEST";  
			pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			list = new ArrayList<Request>();
		  while(rs.next()) {
			    Request request = new Request();
				request.setRequestId(rs.getInt("REQUEST_Id"));
				request.setFundType(rs.getString("FUND_TYPE"));
				request.setAmount(rs.getInt("AMOUNT"));
				Date expireDate=rs.getDate("EXPIRE_DATE");
				request.setExpireDate(expireDate.toLocalDate());
			    list.add(request);
		  }
		  }
	  catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_LIST_REQUEST, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return list;
	}
}


	
	 
		 
	 
		 
	
	


