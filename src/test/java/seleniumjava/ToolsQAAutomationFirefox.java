package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAAutomationFirefox {
	public static void main(String[] args) throws InterruptedException {
		
	   System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
	//	WebDriver driver =new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
    	WebDriver driver =new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://demoqa.com/automation-practice-form");
		
		
		driver.findElement(By.id("firstName")).sendKeys("Arya");
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Raju");
		driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("Arya@gmail.com");
		
		driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
	
		driver.findElement(By.id("userNumber")).sendKeys("6423142321");
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.id("dateOfBirthInput")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'25')]")).click();
	    driver.findElement(By.id("subjectsInput")).sendKeys("Electronics");
	    Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.xpath("//label[contains(text(),'Music')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Reading')]")).click();
		js.executeScript("window.scrollBy(0,350)");
		
		driver.findElement(By.id("currentAddress")).sendKeys("Bangalore, Karnataka");
		
	
		driver.close();
		
		
		
	}
	
}
