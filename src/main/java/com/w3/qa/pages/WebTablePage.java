package com.w3.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3.qa.base.TestBase;

public class WebTablePage extends TestBase{
	
	
	@FindBy(id="addNewRecordButton")
	WebElement addnewrecord;
	@FindBy(id="firstName")
	WebElement firstname;
	@FindBy(id="lastName")
	WebElement lastname;
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="age")
	WebElement userage;
	@FindBy(id="salary")
	WebElement usersalary;
	@FindBy(id="department")
	WebElement userdepartment;
	@FindBy(xpath="//button[@id='submit']")
	WebElement submitbutton;
	@FindBy(xpath="//h1[contains(text(),'Web Tables')]")
	WebElement Webtablelabel;
	
	WebTablePage()
	{
		PageFactory.initElements(e_driver, this); 
	}
	
	public Boolean verifyWebtableLabel()
	{
		System.out.println(Webtablelabel.getText());
	   Boolean b=	Webtablelabel.isDisplayed();
	   return b;
	}
	
	public void  fillRegistrationPage(String efirstname, String elastname, String euseremail,int eage, int eusersalary, String edepartment) {
		addnewrecord.click();
		firstname.sendKeys(efirstname);
		lastname.sendKeys(elastname);
		useremail.sendKeys(euseremail);
		userage.sendKeys(String.valueOf(eage));
		usersalary.sendKeys(String.valueOf(eusersalary));
		userdepartment.sendKeys(edepartment);
		submitbutton.click();
	    	
		
	}
	public boolean isRecordPresent(String email)
	{
	
		List<WebElement>li=e_driver.findElements(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group']"));
		int rows=li.size();
		for(int i=0;i<rows;i++)
		{
			List<WebElement> cols=li.get(i).findElements(By.xpath("div[contains(@class,'rt-tr')]/div[@class='rt-td']"));
					int colssize=cols.size();
					for(int j=0;j<colssize;j++)
					{
						cols.get(j).getText();
						if(cols.get(j).getText().contains(email))
						{
							return true;
							
						}
					}
					
		}
		//int column=driver.findElements(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group']/div[contains(@class,'rt-tr')]"))
		
		return false;
		
	}

}
