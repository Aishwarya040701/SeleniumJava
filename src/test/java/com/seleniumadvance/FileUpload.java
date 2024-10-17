package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;



public class FileUpload {
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
	public void rightClick() throws InterruptedException {
		WebElement fileUploadLink = driver.findElement(By.xpath("//a[text()='File Upload']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", fileUploadLink);
		fileUploadLink.click();
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("C:\\Users\\h.aishwarya\\Downloads\\Axereport.pdf");
		Thread.sleep(2000);
		driver.findElement(By.id("file-submit")).click();
		
		String checkupload = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
		Assert.assertEquals(checkupload, "File Uploaded!");
		
		
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
