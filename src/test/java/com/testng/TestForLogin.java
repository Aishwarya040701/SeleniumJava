package com.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestForLogin {
	
	
	WebDriver driver;
	@BeforeMethod
	public void beforeMethodBrowserSetUp() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
	}

	
	@Test(priority = 1, dataProvider = "validData", dataProviderClass =DataProviderForLogin.class )
	public void LoginSuccess(String username,String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String PageHeading = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		Assert.assertEquals(PageHeading,"Products");
		System.out.println("Valid user");
		
	}
	
	@Test(priority = 2,dataProvider = "invalidData", dataProviderClass =DataProviderForLogin.class )
	public void LoginFailed(String username,String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		String ErrorMessage=driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
		System.out.println("Error Message: "+ErrorMessage);
		Assert.assertEquals(ErrorMessage,"Epic sadface: Username and password do not match any user in this service");
		System.out.println("Invalid user");
		
	}
	
	@Test(priority = 3)
	public void LoginLocked() {
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String ErrorMessage=driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']")).getText();
		System.out.println("Error Message: "+ErrorMessage);
		Assert.assertEquals(ErrorMessage,"Epic sadface: Sorry, this user has been locked out.");
		System.out.println("User has been locked");
		
	}
	
	

	@AfterMethod
	public void afterMethodCloseBrowser() {
		driver.quit();
	}

}
