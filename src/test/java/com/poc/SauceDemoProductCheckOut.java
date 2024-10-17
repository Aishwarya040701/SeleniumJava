package com.poc;

import org.testng.annotations.Test;

import com.data.CustomListerns;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

@Listeners(CustomListerns.class)
public class SauceDemoProductCheckOut {
	
	
	public static WebDriver driver;
	JavascriptExecutor js;
	String product1Name,product2Name;
	
	@BeforeMethod
	public void SetUp() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js=(JavascriptExecutor)driver;
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		
		System.out.println("Browser launched successfully and navigated to saucedemo website ");
	}

	
	@Test
	public void Login() throws InterruptedException {
		WebElement username = driver.findElement(By.id("user-name"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",username);
		username.sendKeys("standard_user");
		
		WebElement password=driver.findElement(By.name("password"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",password);
		password.sendKeys("secret_sauce");
		
		Thread.sleep(1000);
		WebElement loginButton=driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",loginButton);
		loginButton.click();
		
		Thread.sleep(1000);
		String PageHeading = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		Assert.assertEquals(PageHeading,"Products");
		System.out.println("Login successfull!!!");

	
		
	
	

		
		product1Name = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		WebElement product1=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",product1);
		product1.click();
		Thread.sleep(1000);
		String cartCount1=driver.findElement(By.xpath("//span[text()='1']")).getText();
		Assert.assertEquals(cartCount1, "1");
		
		
		product2Name=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		WebElement product2=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",product2);
		product2.click();
		Thread.sleep(1000);
		String cartCount2=driver.findElement(By.xpath("//span[text()='2']")).getText();
		Assert.assertEquals(cartCount2, "2");
		
		System.out.println("Cart value is correct");
		
	
	
		
		
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		
		String p1=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		Assert.assertEquals(product1Name, p1);
		
		System.out.println("product added and product in checkout page is correct");
		String p2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		Assert.assertEquals(product2Name, p2);
		System.out.println("product added and product in checkout page is correct");
		
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).sendKeys("Arya");
		
		driver.findElement(By.id("last-name")).sendKeys("Raju");
		driver.findElement(By.id("postal-code")).sendKeys("573201");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("finish")).click();
		String ThankYouMessage = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		Assert.assertEquals(ThankYouMessage, "Thank you for your order!");
		System.out.println("Product checkout successfull!!!");
		Thread.sleep(1000);
		

	
		//logout
		
		Thread.sleep(1000);
		WebElement menubtn = driver.findElement(By.id("react-burger-menu-btn"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",menubtn);
		menubtn.click();
		Thread.sleep(1000);
		
		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",logoutLink);
		logoutLink.click();
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		System.out.println("Logout successfull!!!");
		
	}
	
	@Test
	public void Logout() throws InterruptedException {
		WebElement username = driver.findElement(By.id("user-name"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",username);
		username.sendKeys("standard_user");
		
		WebElement password=driver.findElement(By.name("password"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",password);
		password.sendKeys("secret_sauce");
		
		Thread.sleep(1000);
		WebElement loginButton=driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",loginButton);
		loginButton.click();
		
		Thread.sleep(1000);
		String PageHeading = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		Assert.assertEquals(PageHeading,"Products");
		System.out.println("Login successfull!!!");

	
		
	
	

		
		product1Name = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		WebElement product1=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",product1);
		product1.click();
		Thread.sleep(1000);
		String cartCount1=driver.findElement(By.xpath("//span[text()='1']")).getText();
		Assert.assertEquals(cartCount1, "1");
		
		
		product2Name=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		WebElement product2=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",product2);
		product2.click();
		Thread.sleep(1000);
		String cartCount2=driver.findElement(By.xpath("//span[text()='2']")).getText();
		Assert.assertEquals(cartCount2, "3");
		
		System.out.println("Cart value is correct");
		
	
	
		
		
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		
		String p1=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		Assert.assertEquals(product1Name, p1);
		
		System.out.println("product added and product in checkout page is correct");
		String p2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		Assert.assertEquals(product2Name, p2);
		System.out.println("product added and product in checkout page is correct");
		
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).sendKeys("Arya");
		
		driver.findElement(By.id("last-name")).sendKeys("Raju");
		driver.findElement(By.id("postal-code")).sendKeys("573201");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("finish")).click();
		String ThankYouMessage = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		Assert.assertEquals(ThankYouMessage, "Thank you for your order!");
		System.out.println("Product checkout successfull!!!");
		Thread.sleep(1000);
		

	
		//logout
		
		Thread.sleep(1000);
		WebElement menubtn = driver.findElement(By.id("react-burger-menu-btn"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",menubtn);
		menubtn.click();
		Thread.sleep(1000);
		
		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
		js.executeScript("arguments[0].style.border='4px solid yellow'",logoutLink);
		logoutLink.click();
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo/");
		System.out.println("Logout successfull!!!");
		
	}

	
	
	

	@AfterMethod
	public void BrowserClose() {
		driver.close();;
	}

}
