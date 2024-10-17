package com.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class SauceDemoProductCheckOut {
	
	
	WebDriver driver;
	String product1,product2;
	
	@BeforeClass
	public void SetUp() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		
		System.out.println("Browser launched successfully and navigated to saucedemo website ");
	}

	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		String PageHeading = driver.findElement(By.xpath("//span[text()='Products']")).getText();
		Assert.assertEquals(PageHeading,"Products");
		System.out.println("Login successfull!!!");

	//	driver.switchTo().alert().accept();
		
	}
	
	@Test(priority = 2)
	public void addingProductToCart() throws InterruptedException {
		
		
		product1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		
		Thread.sleep(1000);
		String cartCount1=driver.findElement(By.xpath("//span[text()='1']")).getText();
		Assert.assertEquals(cartCount1, "1");
		
		product2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
	    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		Thread.sleep(1000);
		String cartCount2=driver.findElement(By.xpath("//span[text()='2']")).getText();
		Assert.assertEquals(cartCount2, "2");
		System.out.println("Cart value is correct");
		
	}
	
	@Test(priority = 3)
	public void ProductCheckOut() throws InterruptedException {
		
		
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		String p1=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		Assert.assertEquals(product1, p1);
		String p2=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		Assert.assertEquals(product2, p2);
		
		System.out.println("Added product is correct");
		
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
		
		Thread.sleep(1000);
		
		
	
		
	}
	
	@Test(priority = 4)
	public void Logout() throws InterruptedException {
		
		//logout
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		System.out.println("Logout successfull!!!");
		
	}

	
	
	

	@AfterClass
	public void BrowserClose() {
		driver.close();
	}

}
