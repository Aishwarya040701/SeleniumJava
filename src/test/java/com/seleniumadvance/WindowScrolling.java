package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;



public class WindowScrolling {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
	}
	
	@Test
	public void rightClick() throws InterruptedException {
		WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",tableElement);
		Thread.sleep(2000);
		
		//js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=-100");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,50)");
		Thread.sleep(2000);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
