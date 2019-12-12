package com.yaswanth.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yaswanth.myfundingapp.dao.TransactionDAO;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Transaction;
import com.yaswanth.myfundingapp.utility.ConnectionUtil;
import com.yaswanth.myfundingapp.utility.MessageConstant;

  
/**
 * @author yaswanth
 * This class consists of Transaction operation
 */
public class TransactionDAOImpl implements TransactionDAO {
	 /**
     * This  method will be shown in test case to inserting the Transaction details in the application
     * @param amountfunded
     * @param donorId
     * @param requestId
	 * @throws DBException
	 * @return rows
     */
       public int insert(Transaction trans) throws DBExeception{
		Connection con=null;
		PreparedStatement pst=null;
		Integer rows=0;
		try {
			con=ConnectionUtil.getConnection();
			String sql="INSERT INTO TRANSACTION(REQUEST_Id,DONOR_Id,AMOUNTFUNDED) values(?,?,?) ";
			pst=con.prepareStatement(sql);
			pst.setInt(2,trans.getDonorId());
			pst.setInt(3, trans.getAmountfunded());
			pst.setInt(1, trans.getRequestId());
			rows=pst.executeUpdate();
		} catch (SQLException e) {
			throw new DBExeception(MessageConstant.UNABLE_TO_INSERT, e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}return rows;
	}  
       
}