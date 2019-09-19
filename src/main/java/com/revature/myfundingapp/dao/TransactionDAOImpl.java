package com.revature.myfundingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.exceptions.DBExeception;

import com.revature.myfundingapp.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO {
       public int insert(Transaction trans) throws DBExeception{
		
		Connection con=null;
		PreparedStatement pst=null;
		Integer rows=0;
		try {
			con=ConnectionUtil.getConnection();
			String sql="INSERT INTO TRANSACTION(id,donor_id,amountFUNDED)values(?,?,?) ";
			pst=con.prepareStatement(sql);
			pst.setInt(2,trans.getDonor_id());
			pst.setInt(3, trans.getAmountfunded());
			pst.setInt(1, trans.getId());
			 rows=pst.executeUpdate();
		
		} catch (SQLException e) {
			throw new DBExeception("Unable to insert rows", e);
		} finally {
			ConnectionUtil.close(con, pst, null);
		}return rows;
	}

     
}