package com.w3.qa.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.w3.qa.base.TestBase;
import com.w3.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		
	}
	
	@Test (priority=1)
	public void validateLoginSuccess()
	{
		loginpage.login("abhilasha_varshney","Abhilasha2*");
		String geturl=loginpage.currentURL();
		System.out.println(geturl);
		AssertJUnit.assertEquals(geturl, "https://demoqa.com/profile");
		//String geturl=loginpage.validatecurrentURL();
		//System.out.println(geturl);
		
		
	}
	@Test (priority=2)
	public void validateLoginfailure()
	{
		loginpage.login("abhilasha_varshney1","Abhilasha2*");
		String geturl=loginpage.currentURL();
		System.out.println(geturl);
		AssertJUnit.assertEquals(geturl, "https://demoqa.com/profile");
		
	}
	
	

@AfterMethod
public void tearDown()
{
	e_driver.quit();
}


}