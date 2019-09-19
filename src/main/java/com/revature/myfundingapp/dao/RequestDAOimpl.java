package com.revature.myfundingapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.model.Request;

public class RequestDAOimpl {
	
	public int insert(Request request) throws DBExeception{
			Connection con = null;
			PreparedStatement pst = null;
			int Isinserted = 0;
			try {
				con = ConnectionUtil.getConnection();
				String sql="insert into Request(Fund_type,Amount,Admin_Id,Expire_date) values(?,?,?,?) ";
				pst=con.prepareStatement(sql);
				Date Expire_date = Date.valueOf(request.getExpire_date());
				pst.setString(1, request.getFund_type());
				pst.setInt(2, request.getAmount());
			    pst.setDate(4, Expire_date);
				pst.setInt(3, request.getAdmin_id());
				 if(pst.executeUpdate() == 1)
					{
						Isinserted = 1;
					}
			} catch (SQLException e) {
				throw new DBExeception("Unable to insert user", e);
			} finally {
				ConnectionUtil.close(con, pst, null);
			} return Isinserted;
	}

	public Request toRow(ResultSet rs) {
		Request request = null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
            Integer Id=rs.getInt("id");
			String Fund_type1 = rs.getString("Fund_type");
			Integer Amount = rs.getInt("target_amount");
			Date Expire_date=rs.getDate("Expire_date");
			Date Announced_date=rs.getDate("Announced_date");
			Integer Amountneeded=rs.getInt("Amountneeded");
			request = new Request();
			request.setId(Id);
			request.setExpire_date(Expire_date.toLocalDate());
			request.setFund_type(Fund_type1);
			request.setAmount(Amount);
			request.setAnnounced_date(Announced_date.toLocalDate());
			request.setAmountneeded(Amountneeded);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con, pst, null);
		}
		return request;
	}

	public  Request findBytype(String Fund_type) {
		Connection con = ConnectionUtil.getConnection();
		Request request = null;
		try {
			String sqlStmt ="Select Id,Announced_date,Fund_type,expire_date,amount as target_amount,(amount-(select ifnull(sum(amountFunded),0) from transaction where id =r.id)) as Amountneeded from request r" + 
					" where Fund_type = ? and amount > IFNULL((select sum(amountfunded) from transaction where id=r.id),0)";
			PreparedStatement pst = con.prepareStatement(sqlStmt);
			pst.setString(1,Fund_type);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				request = toRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return request;
	}

}


