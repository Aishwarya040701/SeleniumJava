package com.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestForLoginParameterAnnotation {
	
	
	WebDriver driver;
	@BeforeMethod
	public void beforeMethodBrowserSetUp() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/v1/");
	}

	
	
	@Parameters({"username","password"})
	@Test()
	public void Login(String username,String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String PageHeading = driver.findElement(By.xpath("//div[text()='Products']")).getText();
		Assert.assertEquals(PageHeading,"Products");
		
	}

	@AfterMethod
	public void afterMethodCloseBrowser() {
		driver.close();
	}

}
