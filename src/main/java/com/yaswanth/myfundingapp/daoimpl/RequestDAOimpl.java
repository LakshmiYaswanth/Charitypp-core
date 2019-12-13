package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.model.RequestType;
import com.yaswanth.myfundingapp.utility.ConnectionUtil;
import com.yaswanth.myfundingapp.utility.MessageConstant;



/**
 * @author yaswanth
 * This class consists of fund request operation
 */
public class RequestDAOimpl {
	 /**
     * This  method will be shown in test case to inserting the Fund request in the application
     * @param fundtype
     * @param amount
     * @param expireDate
     * @param adminId
	 * @throws DBException
	 * @return DonorListobj
     */ 
	public int insert(Request request) throws DBExeception{
			Connection con = null;
			PreparedStatement pst = null;
			int row = 0;
			try {
				con = ConnectionUtil.getConnection();
				String sql=" INSERT INTO REQUEST (FUNDTYPE_ID,AMOUNT,EXPIRE_DATE,ADMIN_Id,DESCRIPTION) VALUES (?,?,?,?,?)";
				pst=con.prepareStatement(sql);
				Date expireDate = Date.valueOf(request.getExpireDate());
				pst.setInt(1, request.getFundTypeId());
				pst.setInt(2, request.getAmount());
			    pst.setDate(3, expireDate);
				pst.setInt(4, request.getAdminId());
				pst.setString(5, request.getDescription());
				row=pst.executeUpdate();
			} catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_INSERT, e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			} return row;
	}
	 /**
     * This method will be shown in test case to Fund request to rows for a given name in the application
     * @param Result set
	 * @throws DBException
	 * @return DonorListobj
     */
	public Request toRow(ResultSet rs) {
		Connection con=null;
		PreparedStatement pst=null;
		Request request=null;
		try {
            Integer requestId=rs.getInt("REQUEST_ID");
			Integer fundTypeId = rs.getInt("FUNDTYPE_ID");
			Integer amount = rs.getInt("Target_Amount");
			Date expireDate=rs.getDate("EXPIRE_DATE");
			Date announcedDate=rs.getDate("ANNOUNCED_DATE");
			Integer amountneeded=rs.getInt("AMOUNT_NEEDED");
			String description=rs.getString("DESCRIPTION");
			String status=rs.getString("STATUS");
			RequestType requesttype=new RequestType();
			requesttype.setFundType(rs.getString("FUNDTYPE"));
		    request= new Request();
			request.setRequestId(requestId);
			request.setExpireDate(expireDate.toLocalDate());
			request.setFundTypeId(fundTypeId);
			request.setAmount(amount);
			request.setRequestType(requesttype);
			request.setDescription(description);
			request.setAnnouncedDate(announcedDate.toLocalDate());
			request.setAmountneeded(amountneeded);
			request.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return request;
	}
	/** List fund type where we have to give only valid inputs 
	 * @param fundType
	 * @return
	 * @throws DBExeception
	 */
	public List<Request> findBytype(Integer fundTypeId)throws DBExeception {
		Connection con = ConnectionUtil.getConnection();
		Request request = null;
		List<Request> list = null;
		try {
			list =new ArrayList<Request>();
			String sqlStmt="Select REQUEST_Id,ANNOUNCED_DATE,FUNDTYPE_ID,(SELECT FUNDTYPE FROM REQUESTTYPE Where FUNDTYPE_ID=r.FUNDTYPE_ID) as FUNDTYPE,EXPIRE_DATE,DESCRIPTION,STATUS,AMOUNT as Target_Amount,(AMOUNT-(select ifnull(sum(AMOUNTFUNDED),0) from TRANSACTION where REQUEST_Id =r.REQUEST_Id)) as AMOUNT_NEEDED,EXPIRE_DATE FROM REQUEST r where FUNDTYPE_ID = ? AND EXPIRE_DATE and AMOUNT > IFNULL((select sum(AMOUNTFUNDED) from TRANSACTION  where AMOUNTFUNDED BETWEEN 0 and AMOUNT AND REQUEST_Id=r.REQUEST_Id),0)";
			System.out.println(sqlStmt);
			PreparedStatement pst = con.prepareStatement(sqlStmt);
			pst.setInt(1,fundTypeId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				request = toRow(rs);
				list.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
		}
		return list;
	}
	public Integer StatusCheck(int requestId) throws DBExeception{
		Connection con=ConnectionUtil.getConnection();
		 Integer rows=0;
		try {
			String sqlStmt="update Request r set Status=? where REQUEST_Id = ? and Amount>=(Select ifnull(sum(AMOUNTFUNDED),0) from TRANSACTION T where t.REQUEST_Id =r.REQUEST_Id)";
			PreparedStatement pst=con.prepareStatement(sqlStmt);
			pst.setString(1,"closed");
			pst.setInt(2, requestId);
		    rows=pst.executeUpdate();	
		    }catch (SQLException e) {
				throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
			}
		return(rows);
	}
	 /**
     * This  method will be shown in test case to updating the Fund request in the application
     * @param fundtype
     * @param amount
     * @param expireDate
     * @param adminId
	 * @throws DBException
	 * @return DonorListobj
     */
	public int updateRequestlist(Request request) throws DBExeception {
		Connection con = null;
		PreparedStatement pst = null;
		int IsUpdated=0;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "UPDATE REQUEST SET FUNDTYPE_ID=,DESCRIPTION=?,AMOUNT=?,EXPIRE_DATE=? WHERE  REQUEST_Id=?";
			pst = con.prepareStatement(sql);
			Date Expire_Date = Date.valueOf(request.getExpireDate());
			pst.setInt(1, request.getFundTypeId());
			  pst.setString(2,request.getDescription());
			pst.setInt(3, request.getAmount());
		    pst.setDate(4, Expire_Date);
			pst.setInt(5, request.getRequestId());
			IsUpdated = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_UPDATE, e);
		} finally {
			ConnectionUtil.close(con, pst,null);	
		}
		return IsUpdated;		
	}
	
	/**
     * This  method will be shown in test case to Request List for a given name in the application
     * @param name
	 * @return list
     */
 public List<Request> list() throws DBExeception{
	 Connection con =null;
	 PreparedStatement pst =null;
	 List<Request> list=null;
	 try {
			con=ConnectionUtil.getConnection();
			String sql="SELECT REQUEST_Id,FUNDTYPE_ID,(SELECT FUNDTYPE FROM REQUESTTYPE Where FUNDTYPE_ID=r.REQUEST_Id) as FUNDTYPE,DESCRIPTION,AMOUNT,EXPIRE_DATE,STATUS from REQUEST r;";  
			pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			list = new ArrayList<Request>();
		  while(rs.next()) {
			     RequestType requesttype=new RequestType();
			     requesttype.setFundType(rs.getString("FUNDTYPE"));
			    Request request = new Request();
				request.setRequestId(rs.getInt("REQUEST_Id"));
				request.setFundTypeId(rs.getInt("FUNDTYPE_ID"));
				request.setAmount(rs.getInt("AMOUNT"));
				request.setDescription(rs.getString("DESCRIPTION"));
				Date expireDate=rs.getDate("EXPIRE_DATE");
				request.setStatus(rs.getString("STATUS"));
				request.setExpireDate(expireDate.toLocalDate());
				request.setRequestType(requesttype);
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
 public List<RequestType> selectFundType() throws DBExeception{
		Connection con = ConnectionUtil.getConnection();
		RequestType requesttype = null;
		List<RequestType> list = null;
		try {
			String smt = "SELECT FUNDTYPE,FUNDTYPE_ID FROM REQUESTTYPE;";
			PreparedStatement pst = con.prepareStatement(smt);
			ResultSet rs = pst.executeQuery();
			
			list = new ArrayList<RequestType>();
			while (rs.next()) {
				requesttype = new RequestType();
				requesttype.setFundType(rs.getString("FUNDTYPE"));
				requesttype.setFundTypeId(rs.getInt("FUNDTYPE_ID"));
				 list.add(requesttype);
			}
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_REQUEST, e);
		}
		return list;
		
	}
}


	
	 
		 
	 
		 
	
	


