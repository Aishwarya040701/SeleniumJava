package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;



public class RightClick {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://user:admin@the-internet.herokuapp.com/");
		
		
		
	}
	
	@Test
	public void rightClick() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
		WebElement contextBox = driver.findElement(By.id("hot-spot"));
		contextBox.click();
		
		
		
		Actions action=new Actions(driver);
		action.contextClick(contextBox).build().perform();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
