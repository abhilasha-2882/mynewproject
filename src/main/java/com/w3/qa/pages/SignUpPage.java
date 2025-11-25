package com.w3.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w3.qa.base.TestBase;
import com.w3.qa.util.TestUtil;

public class SignUpPage extends TestBase{
	
	//@FindBy(xpath="//a[contains(text(),'Signup Form')]")
	//WebElement signUpLink;
	
	@FindBy(xpath="//button[contains(text(),'New User')]")
	WebElement newuser;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='userName']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement registerbutton;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	} 
	
	
	public String Signup(String efirstname, String elastname, String eusername, String epassword)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", newuser);
		newuser.click();	
	    // Check for CAPTCHA presence
	    if (driver.getPageSource().contains("CAPTCHA")) {
	        if (TestBase.captchaBypass) {
	            System.out.println("CAPTCHA detected but bypass is enabled.");
	            // Optionally inject dummy token if needed
	            ((JavascriptExecutor) driver).executeScript(
	                "document.getElementById('g-recaptcha-response').value='dummy-token';"
	            );
	        } else {
	            System.out.println("CAPTCHA active — registration blocked.");
	            return "CAPTCHA_BLOCKED";
	        }
	    }

		firstname.sendKeys(efirstname);
		lastname.sendKeys(elastname);
		username.sendKeys(eusername);
		password.sendKeys(epassword);
	
		
	
		js.executeScript("arguments[0].scrollIntoView(true);", registerbutton);	
		registerbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	    wait.until(ExpectedConditions.alertIsPresent());

		Alert alert=driver.switchTo().alert();
		String successmessage=alert.getText();
		alert.accept();
		return successmessage;
		
		
	}

}
