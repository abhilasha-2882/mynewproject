package com.w3.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.w3.qa.base.TestBase;

public class WebEventListner  extends TestBase implements WebDriverListener {
	
    public void beforeClick(WebDriver driver, WebElement element) {
        System.out.println("Before clicking on: " + element);
    }

   
    public void afterClick(WebDriver driver, WebElement element) {
        System.out.println("Clicked on: " + element);
    }

   
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }
 
   
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After navigating to: " + url);
    }
   
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Before navigating back");
    }

  
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("After navigating back");
    }

    
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Before navigating forward");
    }

   
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("After navigating forward");
    }

   
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Trying to find element By: " + locator);
    }
    public void onException(Object target, Throwable error) {
        System.out.println("Exception occurred: " + error.getMessage());
        try
        {
        	TestUtil.takeScreenshotAtEndOfTest();
        	
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }
   
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Before changing value of: " + element);
    }

 
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("After changing value of: " + element);
    }

}
