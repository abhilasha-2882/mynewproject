//@author Abhilasha V
package com.w3.qa.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w3.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//input[@placeholder='UserName']")
	@CacheLookup
    WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")
    WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(e_driver, this);
	}
   public ProfilePage login(String eusername, String epassword)
   {
	  
	   username.sendKeys(eusername);
	   password.sendKeys(epassword);
	   JavascriptExecutor js=(JavascriptExecutor)e_driver;
		js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
		
	   loginButton.click();
	   return new ProfilePage();
	 
   }
   
   public String currentURL()
   {
	   
	   WebDriverWait wait = new WebDriverWait(e_driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.urlContains("profile")); 
	  return e_driver.getCurrentUrl();
	   
   }
}


