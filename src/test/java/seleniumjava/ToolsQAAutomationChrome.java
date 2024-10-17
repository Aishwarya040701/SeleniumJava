package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAAutomationChrome {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();
    	WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://demoqa.com/automation-practice-form");
		
		
		driver.findElement(By.id("firstName")).sendKeys("Arya");
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Raju");
		driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("Arya@gmail.com");
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
	
		driver.findElement(By.id("userNumber")).sendKeys("6423142321");
		
		driver.findElement(By.id("dateOfBirthInput")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'25')]")).click();
	    driver.findElement(By.id("subjectsInput")).sendKeys("Electronics");
		driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();
		js.executeScript("window.scrollBy(0,350)");
		
		driver.findElement(By.id("currentAddress")).sendKeys("Bangalore, Karnataka");
		
		
//		driver.findElement(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]")).click();
//		WebElement browserWindow = driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]"));
//		browserWindow.click();
//		String browserWindowUrl = browserWindow.getText();
//		System.out.println("browserWindowUrl");


		
	
		driver.close();
		
		
		
	}
	
}
