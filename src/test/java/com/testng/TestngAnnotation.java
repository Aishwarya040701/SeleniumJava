package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngAnnotation {
  @Test(priority=1)
  public void f() {
	  System.out.println("Test: Aishu");
  }
  @Test(priority=2)
  public void f2() {
	  System.out.println("Test: Arya");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BeforeMethod: Whats you are name");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod: nice name");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("BeforeClass: Hai");
  }

 @AfterClass
  public void afterClass() {
	  System.out.println("AfterClass: Bye");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest: Hello");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest: Takecare");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite: 1");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite: 100");
  }

}
