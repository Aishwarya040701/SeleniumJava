package com.seleniumadvance;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadAutoIt {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://altoconvertpdftojpg.com/");

	}

	@Test
	public void rightClick() throws InterruptedException {

		try {
			driver.findElement(By.id("browse")).click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:\\Users\\h.aishwarya\\Desktop\\AutoItScript\\FileUpload.exe");
		} catch (IOException e) {

			e.printStackTrace();
		}

		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
