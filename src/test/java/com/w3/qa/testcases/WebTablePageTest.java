package com.w3.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w3.qa.base.TestBase;
import com.w3.qa.pages.LoginPage;
import com.w3.qa.pages.ProfilePage;
import com.w3.qa.pages.WebTablePage;
import com.w3.qa.util.TestUtil;

public class WebTablePageTest extends TestBase {
	
	LoginPage loginpage;
	ProfilePage profilepage;
	WebTablePage webtablepage;
	String sheetname="abhilasha";
	WebTablePageTest()

	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage =new LoginPage();
		loginpage.login("abhilasha_varsheny", "Abhilasha2*");
		profilepage=new ProfilePage();
		 webtablepage= profilepage.clickOnElementlink("Web Tables");
	}
	
	@Test(priority=1)
	public void verifyWebtableLabelTest()
	{
		boolean b=webtablepage.verifyWebtableLabel();
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=2, dataProvider="getw3TestData")
	public void verifyfillRegistrationPageTest(String firstname, String lastname,String email, int age, int salary, String department)
	{
		webtablepage.fillRegistrationPage(firstname,lastname,email,age,salary,department);
		//webtablepage.isRecordPresent("abhilasha.varshney@gmail.com");
		//Assert.assertTrue(webtablepage.isRecordPresent("abhilasha.varshney@gmail.com"));
	}
	
	@Test(priority=3)
	public void validateRecordpresentTest()
	
	{
		webtablepage.fillRegistrationPage("abhilasha", "varshney", "abhilasha.varshney@gmail.com", 10, 2330, "Information technology");

		Assert.assertTrue(webtablepage.isRecordPresent("abhilasha.varshney@gmail.com"));

	}
	
	@DataProvider
	public Object[][] getw3TestData() throws InvalidFormatException
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		e_driver.quit();
		
	}
}
