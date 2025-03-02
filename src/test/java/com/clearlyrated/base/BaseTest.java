package com.clearlyrated.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.clearlyrated.factory.DriverFactory;

import com.clearlyrated.pages.ProfilesPage;



public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory df;
	protected Properties prop;

   protected ProfilesPage profilePage;
   //protected ProfileSorter profileSorter;
  

    @BeforeClass
    public void setup() {
       System.out.println("im in base test");
       df = new DriverFactory();
    	prop = df.initProp();
    	driver = df.initDriver(prop);
      //  driver = new ChromeDriver();
       // driver.manage().window().maximize();
        //driver.get("https://www.clearlyrated.com/staffing/md-usa/hanover-md/actalent-hanover-md");
       profilePage = new ProfilesPage(driver);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
