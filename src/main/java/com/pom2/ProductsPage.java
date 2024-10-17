package com.pom2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsPage {
	
	private WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> listOfProductsName;
	
	@FindBy(xpath="//select[@data-test='product_sort_container']")
	WebElement dropdown;
	
	@FindBy(xpath="//div[@class='inventory_item']")
	List<WebElement> ListOfItems;
	
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement product1;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	public static WebElement product1Name;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement product2;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']")
	public static WebElement product2Name;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement product3;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement product4;
	
	@FindBy(id="remove-sauce-labs-bike-light")
	WebElement removeProduct3;
	
	@FindBy(id="remove-sauce-labs-fleece-jacket")
	WebElement removeProduct4;
	
	@FindBy(xpath="//span[text()='2']")
	public static WebElement cartValue;
	
	
	
	@FindBy(id="shopping_cart_container")
	WebElement cartButton;
	
	public void AddToCart() {
		product1.click();
		product2.click();
		System.out.println("Products added");
		
	}
	
	public void ToCheckCartValue() {
		product1.click();
		product2.click();
		product3.click();
		product4.click();
		System.out.println("Products added");
		
	}
	
	public void RemoveFromCart() {
		removeProduct3.click();
		removeProduct4.click();
		System.out.println("Products Removed");
		
	}
	public void VerifyCartValue(String cartvalue) {
		
		Assert.assertEquals(cartValue.getText(), cartvalue);
		System.out.println("Cart value is correct");
	}
	
	public void cartButton() {
		cartButton.click();
	}
	
	public void Sort(String Value) {
		new Select(dropdown).selectByValue(Value);
	}
	
	public void ListOfitems() {
		System.out.println("Product counts: "+ListOfItems.size());
		System.out.println("Products Details:   ");
		for(WebElement element:ListOfItems) {
			System.out.println(element.getText());
		}
	}
	
	// verifying sorting
	public void CheckSorting(String value) {
		if (value.equals("za")) {
			// new Select(dropdown).selectByValue(value);

			Assert.assertEquals(listOfProductsName.get(0).getText(), "Test.allTheThings() T-Shirt (Red)");
			System.out.println("Sorting z to a successfull!!");

		} else if (value.equals("az")) {
			// new Select(dropdown).selectByValue(value);

			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Backpack");
			System.out.println("Sorting a to z successfull!!");

		} else if (value.equals("lohi")) {
			// new Select(dropdown).selectByValue(value);

			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Onesie");
			System.out.println("Sorting low to high price successfull!!");

		} else if (value.equals("hilo")) {
			// new Select(dropdown).selectByValue(value);

			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Fleece Jacket");
			System.out.println("Sorting high to low price successfull!!");

		}
	}


}
