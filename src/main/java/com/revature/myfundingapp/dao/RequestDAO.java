package com.revature.myfundingapp.dao;

import java.sql.ResultSet;
import java.util.List;

import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Request;

public interface RequestDAO {
   public void insert(Request request) throws DBExeception; 
   public Request toRow(ResultSet rs) throws DBExeception;
  
   public  Request findBytype(int id)throws DBExeception;
}
