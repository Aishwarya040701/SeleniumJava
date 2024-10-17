package seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAAlerts {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();
    	WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,300)");
		
		//simple alert
		 driver.findElement(By.id("alertButton")).click();
		 Alert simpleAlert =driver.switchTo().alert();
		 simpleAlert.accept();
		 Thread.sleep(2000);
		 
		 
		 
		 //simple alert with ok and cancel 
		 driver.findElement(By.id("confirmButton")).click();
		 Alert simpleAlert2 =driver.switchTo().alert();
		 simpleAlert2.accept();
		 System.out.println("Message : "+driver.findElement(By.id("confirmResult")).getText());
		 Thread.sleep(2000);
		 
		 
		 //promt Alert
		 driver.findElement(By.id("promtButton")).click();
		 Alert promtAlert2 =driver.switchTo().alert();
		 System.out.println(promtAlert2.getText());
		 promtAlert2.sendKeys("Arya");
		 promtAlert2.accept();
		 System.out.println("Message Entered : "+driver.findElement(By.id("promptResult")).getText());
		 Thread.sleep(2000);
		 
		 
		 
		
			
		}
		
		
		
		
		
	}
	

