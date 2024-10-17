package com.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.data.DataProviderLogin;
import com.data.ReadPropertiesFile;
import com.pom2.LoginPage;
import com.pom2.ProductsPage;
import com.testng.DataProviderForLogin;

public class SauceWebsiteCartValueVerification {

	WebDriver driver;
	public static String driverLocation, sauceWebsiteUrl;

	//@BeforeMethod
	public void SetUp() {
		// WebDriverManager.chromedriver().setup();
		ReadPropertiesFile read = new ReadPropertiesFile();
		read.GetProperties();
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(sauceWebsiteUrl);
		Assert.assertEquals(driver.getCurrentUrl(), sauceWebsiteUrl);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

	}

	@Test
	public void CartValueVerification() {
		LoginPage login = new LoginPage(driver);
		login.Login("standard_user", "secret_sauce");

		ProductsPage product = new ProductsPage(driver);

		try {
			product.ToCheckCartValue();
			Thread.sleep(2000);
			product.RemoveFromCart();
			Thread.sleep(2000);
			product.VerifyCartValue("2");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	//@AfterMethod
	public void BrowserClose() {
		driver.close();
	}

}
