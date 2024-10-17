package seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAwebTabel {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver =new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();
    	WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.get("https://demoqa.com/webtables");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		 List<WebElement> row = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
		 List<WebElement> col = driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
		 int colcount=col.size();
		 int rowcount=row.size();
		 System.out.println("Row: "+rowcount+" Col: "+colcount);
		for(int i=1;i<4;i++) {
			
			for(int j=1;j<colcount;j++) {
				
				
				
				System.out.println(driver.findElement(By.xpath("//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td']["+j+"]")).getText());
			}
		
			
		}
		
		
		
		
		
	}
	
}
