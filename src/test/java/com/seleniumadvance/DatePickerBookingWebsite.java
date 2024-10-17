package com.seleniumadvance;

import java.time.Duration;
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

public class DatePickerBookingWebsite {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.booking.com");

	}

	@Test
	public void datePicker() throws InterruptedException {
		String checkInDate, checkOutDate, actualDate, currentMonth, expectedMonth;
		checkInDate = "20";
		checkOutDate = "25";
		expectedMonth = "december";
		String expectedYear = "2023";
		driver.findElement(By.id("flights")).click();
		driver.findElement(By.xpath("//button[@data-ui-name='button_date_segment_0']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// driver.findElement(By.xpath("(//span[@class='Button-module__icon___sDvkX'])[6]")).click();
		currentMonth = driver.findElement(By.xpath("(//h3[@aria-live='polite'])[1]")).getText();
		String[] cMonth = currentMonth.split(" ");
		System.out.println(cMonth[0] + " " + cMonth[1]);

		while (!(cMonth[1].equalsIgnoreCase(expectedYear))) {
			driver.findElement(By.xpath("(//span[@class='Button-module__icon___sDvkX'])[7]")).click();
			currentMonth = driver.findElement(By.xpath("(//h3[@aria-live='polite'])[1]")).getText();
			cMonth = currentMonth.split(" ");
		}

		while (!(cMonth[0].equalsIgnoreCase(expectedMonth))) {
			driver.findElement(By.xpath("(//span[@class='Button-module__icon___sDvkX'])[7]")).click();
			currentMonth = driver.findElement(By.xpath("(//h3[@aria-live='polite'])[1]")).getText();
			cMonth = currentMonth.split(" ");
		}

		List<WebElement> date = driver.findElements(By.xpath(
				"//div[@class='Calendar-module__monthWrapper___6FH+y'][1]//td[@class='Calendar-module__cell___om-cl']"));

		for (int i = 0; i <= date.size(); i++) {
			actualDate = date.get(i).getText();
			if (actualDate.equalsIgnoreCase(checkInDate)) {
				date.get(i).click();
				Thread.sleep(2000);
				for (int j = i + 1; j <= date.size(); j++) {
					actualDate = date.get(j).getText();
					if (actualDate.equalsIgnoreCase(checkOutDate)) {
						date.get(j).click();
						Thread.sleep(2000);
						break;
					}

				}
				break;
			}

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
