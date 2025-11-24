package com.w3.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w3.qa.base.TestBase;
import com.w3.qa.pages.LoginPage;
import com.w3.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase {
	
	ProfilePage profilepage;
	LoginPage loginpage;
	public ProfilePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		profilepage= loginpage.login("abhilasha_varshney", "Abhilasha2*");	
		// profilepage=new ProfilePage();
		 
	}
	
	@Test
	public void validateusernamelabel()
	{
		
		String str=profilepage.getLabelnamevalue();
		System.out.println(str);
		Assert.assertEquals(str, "abhilasha_varshney");
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		e_driver.quit();
	}
}
