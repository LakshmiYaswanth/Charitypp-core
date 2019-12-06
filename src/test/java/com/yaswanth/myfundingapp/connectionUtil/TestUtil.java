package com.yaswanth.myfundingapp.connectionUtil;



import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.yaswanth.myfundingapp.utility.ConnectionUtil;

public class TestUtil {

	@Test
		public void testConnection() {
			ConnectionUtil.getConnection();
			assertTrue(true);
	}
	
}

	


