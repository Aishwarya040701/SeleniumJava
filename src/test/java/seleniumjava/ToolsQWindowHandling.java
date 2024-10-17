package seleniumjava;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQWindowHandling {
	

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		WebDriverManager.chromedriver().setup();
//    	WebDriver driver =new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		 driver.get("https://demoqa.com/browser-windows");

	

	
		String mainWin = driver.getWindowHandle();
		//driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("tabButton")).click();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWin = itr.next();
			if (!mainWin.equals(childWin)) {
				Thread.sleep(2000);
				driver.switchTo().window(childWin);
				Thread.sleep(2000);
				System.out.println("ChildWindow url: " + driver.getCurrentUrl());
				
			}
		}
		driver.switchTo().window(mainWin);
		System.out.println("MainWindow url: " + driver.getCurrentUrl());
	
     
 }
	
}
