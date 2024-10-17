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



public class DargAndDrop {
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
	public void dargAndDrop() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		Actions action=new Actions(driver);
//		action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		action.dragAndDrop(drop, drag);
		action.build().perform();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
