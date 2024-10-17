package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductsPage {

	public WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//select[@data-test='product_sort_container']")
	WebElement dropdown;

	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> ListOfItems;

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> listOfProductsName;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement product1;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	public WebElement product1Name;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement product2;

	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	public WebElement product2Name;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement product3;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement product4;

	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement removeProduct3;

	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	WebElement removeProduct4;

	@FindBy(xpath = "//span[text()='2']")
	public WebElement cartValue;

	@FindBy(id = "shopping_cart_container")
	WebElement cartButton;

	// adding products to cart
	public void AddToCart() {
		product1.click();
		product2.click();
		System.out.println("Products added");

	}

	// adding products to cart for checking cart value
	public void ToCheckCartValue() {
		product1.click();
		product2.click();
		product3.click();
		product4.click();
		System.out.println("Products added");

	}

	// remove products from
	public void RemoveFromCart() {
		removeProduct3.click();
		removeProduct4.click();
		System.out.println("Products removed");

	}

	// click on cartButton
	public void cartButton() {
		cartButton.click();
	}

	// sorting operation
	public void Sort(String Value) {
		new Select(dropdown).selectByValue(Value);
	}

//	public void CheckSorting(String value) {
//		switch (value) {
//
//		case "az":
//			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Backpack");
//			System.out.println("Sorting a to z successfull!!");
//			break;
//		case "za":
//			Assert.assertEquals(listOfProductsName.get(0).getText(), "Test.allTheThings() T-Shirt (Red)");
//			System.out.println("Sorting z to a successfull!!");
//			break;
//		case "lohi":
//			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Onesie");
//			System.out.println("Sorting low to high price successfull!!");
//			break;
//		case "hilo":
//			Assert.assertEquals(listOfProductsName.get(0).getText(), "Sauce Labs Fleece Jacket");
//			System.out.println("Sorting high to low price successfull!!");
//			break;
//
//		}
//	}

	public void ListOfitems() {
		System.out.println("Product counts: " + ListOfItems.size());
		System.out.println("Products Details:   ");
		for (WebElement element : ListOfItems) {
			System.out.println(element.getText());
		}
	}

}
