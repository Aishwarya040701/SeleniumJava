package com.seleniumadvance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;



public class DatePicker {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.path2usa.com/travel-companion/");
		
		
		
	}
	
	@Test
	public void datePicker() throws InterruptedException {
		String actualDate,expectedDate,currentMonth,expectedMonth;
		expectedDate="10";
		expectedMonth="October";
		int currentYear=2023,expectedYear=2024;
		WebElement datePicker = driver.findElement(By.id("form-field-travel_comp_date"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",datePicker);
		Thread.sleep(2000);
		datePicker.click();
		Thread.sleep(2000);
	
		  currentMonth = driver.findElement(By.xpath("//span[@class='cur-month']")).getText();
//		  String current = driver.findElement(By.xpath("//div[@class='numInputWrapper']")).getText();
		 System.out.println(currentYear);
		 while(!(currentYear==expectedYear)) {
			 driver.findElement(By.xpath("//span[@class='arrowUp']")).click();
			  currentYear = currentYear+1;
		 }
		 
		while(!(currentMonth.equalsIgnoreCase(expectedMonth))) {
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			currentMonth=driver.findElement(By.xpath("//span[@class='cur-month']")).getText();
		}
		
		
		List<WebElement> date = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		
		for (WebElement element : date) {
			actualDate = element.getText();
			 if(actualDate.equalsIgnoreCase(expectedDate)) {
				 element.click();
				Thread.sleep(2000);
				 break;
			 }
			
		}
		
		
		
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
