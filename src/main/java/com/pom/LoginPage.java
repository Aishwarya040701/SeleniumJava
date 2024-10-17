package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Products']")
	public WebElement productsHeading;
	
	@FindBy(xpath="//div[@class='error-message-container error']")
	public WebElement invalidUser;
	
	
	public void Login(String usernameData,String passwordData) {
	
		username.sendKeys(usernameData);
		password.sendKeys(passwordData);
		
	}
	
	public void LoginButton() {
		
		loginButton.click();
		
	}


}
