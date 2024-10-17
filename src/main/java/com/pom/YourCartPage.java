package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class YourCartPage {
	
	public WebDriver driver;
	
	public YourCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	public WebElement product1;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']")
	public WebElement product2;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;

	
	public void Checkout() {
		checkoutButton.click();
	}

}
