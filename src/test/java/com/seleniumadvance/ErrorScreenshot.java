package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorScreenshot {
	WebDriver driver;
	Utility utility = new Utility();

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com");

	}

	@Test
	public void Login() throws InterruptedException {
		try {
			driver.findElement(By.id("user-name")).sendKeys("Arya");
			driver.findElement(By.name("password")).sendKeys("A23");
			driver.findElement(By.id("login-button")).click();
			String PageHeading = driver.findElement(By.xpath("//span[text()='Products']")).getText();
			Assert.assertEquals(PageHeading, "Products");
		} catch (Exception e) {
			utility.getScreenshot(driver, "Login");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
