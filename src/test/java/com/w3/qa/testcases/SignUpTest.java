package com.w3.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w3.qa.base.TestBase;
import com.w3.qa.pages.SignUpPage;

public class SignUpTest extends TestBase{
	SignUpPage signuppage;
	SignUpTest()
	{
		super();
		
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		signuppage=new SignUpPage();
		
	}
	
	@Test
	public void SignupTest()
	{
		String successmessage=signuppage.Signup("Abhilasha", "Varshney", "abhilasha_varshney","Abhilasha2*");
		Assert.assertEquals(successmessage, "User Register Successfully.");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
