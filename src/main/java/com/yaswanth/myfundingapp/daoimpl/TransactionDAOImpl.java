package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.yaswanth.myfundingapp.dao.TransactionDAO;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Transaction;
import com.yaswanth.myfundingapp.utility.ConnectionUtil;
import com.yaswanth.myfundingapp.utility.MessageConstant;

/* insert Transaction where we have to give only valid inputs */  
public class TransactionDAOImpl implements TransactionDAO {
	Logger logger=Logger.getLogger(TransactionDAOImpl.class);
       public int insert(Transaction trans) throws DBExeception{
		Connection con=null;
		PreparedStatement pst=null;
		Integer rows=0;
		String error = null;
		try {
			con=ConnectionUtil.getConnection();
			String sql="INSERT INTO TRANSACTION(REQUEST_Id,DONOR_Id,AMOUNTFUNDED) values(?,?,?) ";
			pst=con.prepareStatement(sql);
			pst.setInt(2,trans.getDonorId());
			pst.setInt(3, trans.getAmountfunded());
			pst.setInt(1, trans.getRequestId());
			rows=pst.executeUpdate();
			logger.info("Amount is funded to the Fund Request");
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_INSERT, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}return rows;
	}  
       
}