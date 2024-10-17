package com.seleniumadvance;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSuggestionsClick {

	WebDriver driver;

	@BeforeClass
	public void Open() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		
	

	}

	@DataProvider(name="data")
	public Object[][] DataToSearch() {

		return new Object[][] {
			{"java","javatpoint"},
			{"selenium","selenium tutorial"},
			{"electronics","electronics shop near me"},
			{"chocholate","chocolate shop near me"}

		};

	}


	@Test(dataProvider = "data")
	public void Search(String sName,String sValue ) throws Exception {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='QlyBfb']//button[@aria-label='No thanks']")).click();
		WebElement Element = driver.findElement(By.id("APjFqb"));
		Element.clear();
		Element.sendKeys(sName);

		List<WebElement> suggestions = driver.findElements
				(By.xpath("//ul//li/descendant::div[@class='pcTkSc']"));
		//(By.xpath("//ul//li[@role='presentation']/descendant::div[@class='pcTkSc']"));

		System.out.println("\nTotal suggestion==>"+suggestions.size());

      suggestions.forEach(e->System.out.println(e.getText()));


		for(int i=0;i<=suggestions.size();i++) {

			Thread.sleep(1000);
			if(suggestions.get(i).getText().contains(sValue)) {
				suggestions.get(i).click();
				break;
			}


		}

		Thread.sleep(1000);
		

		//driver.navigate().back();
		
	}
	@AfterClass
	public void close() {
		driver.close();
	
	}

}
