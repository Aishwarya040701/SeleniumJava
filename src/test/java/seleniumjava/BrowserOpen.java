package seleniumjava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOpen {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		
	//	WebDriverManager.chromedriver().setup();
    	WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");
		Thread.sleep(3000);
		
		driver.findElement(By.id("username")).sendKeys("Aishu");
		driver.findElement(By.name("password")).sendKeys("Aishu@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		
		
	}
	
}
