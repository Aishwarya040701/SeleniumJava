package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BasicAuth {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://user:admin@the-internet.herokuapp.com/");//Basic Auth
		
		
		
	}
	
	@Test
	public void basicAuth() {
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
