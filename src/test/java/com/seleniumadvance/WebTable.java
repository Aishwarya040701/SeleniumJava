package com.seleniumadvance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	}

	@Test
	public void readDataFromTable() throws InterruptedException {
		WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tableElement);
		Thread.sleep(2000);
		
		List<WebElement> row = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr"));
		List<WebElement> col = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr[1]//td"));

		for (int i = 1; i < row.size(); i++) {
			for (int j = 1; j < col.size(); j++) {
				System.out.print(
						driver.findElement(By.xpath("//div[@class='tableFixHead']//tr[" + i + "]//td[" + j + "]"))
								.getText() + " ");

			}
			System.out.println("");
		}

	}

	@Test
	public void addCol4() throws InterruptedException {
		WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tableElement);
		Thread.sleep(2000);

		List<WebElement> col = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr//td[4]"));
		List<Integer> ColumValue = new ArrayList<>();
		int sum = 0;

		for (int j = 0; j < col.size(); j++) {

			ColumValue.add(Integer.parseInt(col.get(j).getText()));

		}
		for (Integer integer : ColumValue) {
			System.out.println(integer);
			sum += integer;
		}
		System.out.println("Sum of fourth col is : " + sum);

	}

	@Test
	public void findNameRow() throws InterruptedException {
		WebElement tableElement = driver.findElement(By.xpath("//div[@class='tableFixHead']"));
		String SearchName = "Smith";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tableElement);
		Thread.sleep(2000);

		List<WebElement> col = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr//td[1]"));

		for (int j = 0; j <= col.size(); j++) {

			if ((col.get(j).getText()).equalsIgnoreCase(SearchName)) {
				System.out.println("Place Name of "+SearchName +" : "+driver
						.findElement(By.xpath("//div[@class='tableFixHead']//tr[" + (j + 1) + "]//td[3]")).getText());
				break;
			}

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
