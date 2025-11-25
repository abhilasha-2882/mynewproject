package com.w3.qa.testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//@Author-abhilasha varshney
import com.w3.qa.base.TestBase;
import com.w3.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	LoginPageTest()
	{
		super() ;
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		
	}
	
	@Test (priority=1)
	public void validateLoginSuccess() throws IOException
	{
		File file=new File("C:\\Users\\Abhilasha\\OneDrive\\Desktop\\logindata.xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("testdata");
		int rowcount=sheet.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			int cellcount=sheet.getRow(i).getLastCellNum();
			String username=sheet.getRow(i).getCell(0).getStringCellValue();
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(username+" "+password);
			loginpage.login(username, password);
		String geturl=loginpage.currentURL();
		System.out.println(geturl);
		Assert.assertEquals(geturl, "https://demoqa.com/profile");
		//String geturl=loginpage.validatecurrentURL();
			
		}
		
		
		//String geturl=loginpage.validatecurrentURL();
		//System.out.println(geturl);
		
		
	}
	@Test (priority=2, enabled=false)
	public void validateLoginfailure()
	{
		loginpage.login("abhilasha_varshney1","Abhilasha2*");
		String geturl=loginpage.currentURL();
		System.out.println(geturl);
		Assert.assertEquals(geturl, "https://demoqa.com/profile");
		
	}
	
	

@AfterMethod
public void tearDown()
{
	e_driver.quit();
}


}