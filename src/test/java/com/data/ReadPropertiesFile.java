package com.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.pom.SauceWebsiteProductCheckout;

public class ReadPropertiesFile {
	
	public void GetProperties() {
		try {
			FileInputStream fi=new FileInputStream("propertiesFile//SauceWebsite.properties");
			Properties obj=new Properties();
			obj.load(fi);
			SauceWebsiteProductCheckout.driverLocation=obj.getProperty("driverLocation");
			SauceWebsiteProductCheckout.sauceWebsiteUrl=obj.getProperty("sauceUrl");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
