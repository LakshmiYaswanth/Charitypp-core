package com.revature.myfundingapp.connectionUtil;



import org.junit.Test;

import com.revature.myfundingapp.connectionutil.ConnectionUtil;
import com.revature.myfundingapp.exceptions.DBExeception;

public class TestUtil {

	@Test
		public void testConnection() {
			try {
				ConnectionUtil.getConnection();
			} catch (DBExeception e) {
				e.printStackTrace();
			}
	}
	
}

	


