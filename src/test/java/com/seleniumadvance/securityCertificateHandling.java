package com.seleniumadvance;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class securityCertificateHandling {
	WebDriver driver;
	ChromeOptions options;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();

	}

	@Test
	public void SSHCertificateTest() throws InterruptedException {
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://expired.badssl.com/");
		Thread.sleep(2000);
	}

	@Test
	public void setProxy() throws InterruptedException {
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:442");
		options.setCapability("prefs", "proxy");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://expired.badssl.com/");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
