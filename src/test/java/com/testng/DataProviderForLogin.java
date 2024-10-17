package com.testng;

import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
	
	
@DataProvider(name="validData")	
public Object[][] LoginDataValid(){
		
		Object[][] logindata =new Object[][] {
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
		
		};
		return logindata;
	}
		
//invalid data
		@DataProvider(name="invalidData")	
		public Object[][] LoginDataInvalid(){
				
				Object[][] logindata =new Object[][] {
					{"arya","secret_sauce"},
					{"Raju","secret_sauce"},
		//invalid	{"standard_user1","secret_sauce"},
			
				};
		
		
		return logindata;
	}

}
