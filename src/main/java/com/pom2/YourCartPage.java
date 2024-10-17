package com.pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class YourCartPage {
	
	private WebDriver driver;
	
	public YourCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement product1;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']")
	WebElement product2;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	public void VerifyProduct() {
		
		Assert.assertEquals(product1.getText(), (ProductsPage.product1Name).getText());
		Assert.assertEquals( product2.getText(), (ProductsPage.product2Name).getText());
		System.out.println("Products verified");
		
		
	}
	
	public void Checkout() {
		checkoutButton.click();
	}

}
