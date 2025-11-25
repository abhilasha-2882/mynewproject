package com.w3.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.w3.qa.util.TestUtil;
import com.w3.qa.util.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static boolean captchaBypass;
    public static WebDriver e_driver;
    public static WebEventListner eventListner;
	
public TestBase()
{
	try
	{
		 prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Abhilasha\\eclipse-workspace\\New_Project\\src\\main\\java\\com\\w3\\qa\\config\\config.properties");
		prop.load(ip);
		 //captchaBypass = Boolean.parseBoolean(prop.getProperty("captcha.bypass"));

	}
    catch(FileNotFoundException e)	
	{
    	e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void initialization()
{
  String browserName=	prop.getProperty("browser");
  if(browserName.equals("chrome"))
  {
	  WebDriverManager.chromedriver().setup();
    // System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
  }
  else if (browserName.equals("FirefoxDriver"))
	{System.setProperty("webdriver.geko.driver", "C:\\gekodriver.exe");
		driver=new FirefoxDriver();
	}
//Instantiate your listener
eventListner = new WebEventListner();
//Decorate driver with listener
 e_driver = new EventFiringDecorator(eventListner).decorate(driver);


e_driver.manage().window().maximize();
e_driver.manage().deleteAllCookies();
e_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	e_driver.get(prop.getProperty("url"));
}	
   



}


