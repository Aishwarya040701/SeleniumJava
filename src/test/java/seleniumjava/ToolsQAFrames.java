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

public class ToolsQAFrames {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();
    	WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://demoqa.com/frames");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,350)");
		
	//	System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		//simple alert
		 WebElement frame1 = driver.findElement(By.id("frame1"));
		 System.out.println(driver.switchTo().frame(frame1).getTitle());
		// System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		 
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 
		 js.executeScript("window.scrollBy(0,250)");
		 
		 WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
	     System.out.println(driver.switchTo().frame(frame2).getTitle());
	     Thread.sleep(2000);
	     
	    // System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		 
		 
		 
		 
		
			
		}
		
		
		
		
		
	}
	

