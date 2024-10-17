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
import com.pom2.OverviewPage;
import com.pom2.ProductsPage;
import com.pom2.YourCartPage;
import com.pom2.YourInformationPage;
import com.testng.DataProviderForLogin;

public class SauceWebsiteProductCheckout {

	WebDriver driver;
	public static String driverLocation, sauceWebsiteUrl;

	@BeforeMethod
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
	public void ProductCheckOut() {

		// LoginPage
		LoginPage login = new LoginPage(driver);
		login.Login("standard_user", "secret_sauce");
		login.LoginVerification("Products");

		// ProductsPage
		ProductsPage product = new ProductsPage(driver);
		product.ListOfitems();

		try {
			Thread.sleep(2000);
			product.Sort("za");
			Thread.sleep(2000);
			product.Sort("az");
			Thread.sleep(2000);
			product.AddToCart();
			product.cartButton();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// YourCartPage
		YourCartPage cart = new YourCartPage(driver);
		cart.VerifyProduct();
		cart.Checkout();

		// YourInformationPage
		YourInformationPage information = new YourInformationPage(driver);
		information.EnterDetails("Arya", "Raj", "573201");
		information.ContinueButton();

		// OverviewPage
		OverviewPage overview = new OverviewPage(driver);
		overview.FinishButton();
		overview.VerifyCheckoutCompleted();
		overview.Logout();
		overview.LogoutVerification(sauceWebsiteUrl);
		
		// LoginPage
//		LoginPage login = new LoginPage(driver);
//		login.Login("standard_user", "secret_sauce");
//		login.LoginVerification("Products");
//
//		// ProductsPage
//		ProductsPage product = new ProductsPage(driver);
//		// product.ListOfitems();
//
//		product.AddToCart();
//		product.VerifyCartValue("2");
//		product.cartButton();
//
//		// YourCartPage
//		YourCartPage cart = new YourCartPage(driver);
//		cart.VerifyProduct();
//		cart.Checkout();
//
//		// YourInformationPage
//		YourInformationPage information = new YourInformationPage(driver);
//		information.EnterDetails("Arya", "Raj", "573201");
//		information.ContinueButton();
//
//		// OverviewPage
//		OverviewPage overview = new OverviewPage(driver);
//		overview.FinishButton();
//		overview.VerifyCheckoutCompleted();
//		overview.Logout();
//		overview.LogoutVerification(ReadPropertiesFile.sauceWebsiteUrl);


	}

	@AfterMethod
	public void BrowserClose() {
		driver.close();
	}

}
