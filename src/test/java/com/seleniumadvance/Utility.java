package com.seleniumadvance;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public void getScreenshot(WebDriver driver,String testName) {
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
		String fileName = testName+timestamp;
		try {
			FileUtils.copyFile(sourceFile, new File("Screenshot//"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
