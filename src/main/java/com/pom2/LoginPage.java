package com.pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	private WebDriver driver;
	
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
	WebElement validUser;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	WebElement invalidUser;
	
	
	public void Login(String usernameData,String passwordData) {
		username.sendKeys(usernameData);
		password.sendKeys(passwordData);
		loginButton.click();
		
	}
	
	public void LoginVerification(String Pageheading) {
		Assert.assertEquals(validUser.getText(),Pageheading);
		System.out.println("Login successfull!!!");
			
	}

}
