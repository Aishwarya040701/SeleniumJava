package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class OverviewPage {
	
	public WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="finish")
	WebElement finishButton;
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	public WebElement thankyouMessage;
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menuButton;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutButton;
	
	public void FinishButton() {
		finishButton.click();
		
	}
	
	public void Logout() {
		menuButton.click();
		logoutButton.click();
		
	}
	

}
