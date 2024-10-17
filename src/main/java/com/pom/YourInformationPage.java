package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
	
	public WebDriver driver;
	public YourInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	public void EnterDetails(String firstNameData,String LastNameData, String postalCodeData ) {
		firstName.sendKeys(firstNameData);
		lastName.sendKeys(LastNameData);
		postalCode.sendKeys(postalCodeData);
		System.out.println("Information is entered");
		
	}
	
	public void ContinueButton() {
		continueButton.click();
		
	}
	

}
