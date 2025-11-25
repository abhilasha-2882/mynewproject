package com.w3.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3.qa.base.TestBase;

public class ProfilePage extends TestBase {
	
	
	@FindBy(id="userName-label")
	WebElement usernamelabel;
	@FindBy(id="userName-value")
	WebElement usernamelabelvalue;
	@FindBy(xpath="//div[contains(text(),'Elements')]")
	WebElement elementlink;
	public ProfilePage()
	{
		PageFactory.initElements(e_driver, this);
	}

	public String getLabelnamevalue()
	{
		String userlabelnamebval=usernamelabelvalue.getText();
		return userlabelnamebval;
	} 
   public WebTablePage  clickOnElementlink(String linktext)
   {
	   elementlink.click();
	   List<WebElement> li=e_driver.findElements(By.xpath("//div[@class='element-list collapse show']/ul[@class='menu-list']/li[@class='btn btn-light ']"));
	   for(int i=0;i<li.size();i++)
	   {
		   if(li.get(i).getText().equals(linktext))
		   {
			   li.get(i).click();
		       break;
		   }  
	   }
	   
	   
	   return new WebTablePage();
	   
   }
}

