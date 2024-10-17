package com.data;

import org.testng.annotations.DataProvider;

public class DataProviderLogin {
	
	
@DataProvider(name="LoginData")	
public Object[][] LoginDataValid(){
		
		Object[][] logindata =new Object[][] {
			{"standard_user","secret_sauce"},
			{"arya","secret_sauce"},
			{"locked_out_user","secret_sauce"},
		
		};
		return logindata;
	}
		


}
