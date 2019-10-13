package com.revature.myfundingapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.connectionutil.MessageConstant;
import com.revature.myfundingapp.dao.TransactionDAO;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Transaction;
/* insert Transaction where we have to give only valid inputs */  
public class TransactionDAOImpl implements TransactionDAO {
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