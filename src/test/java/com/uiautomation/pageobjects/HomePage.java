package com.uiautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uiautomation.core.Base;
import com.uiautomation.utilities.InteractionUtility;



public class HomePage extends Base
{
	InteractionUtility action;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		action = new InteractionUtility(driver);
	}
	
	public static By welcomeadminlink = By.xpath("//*[@id='welcome']");
	public static By logoutlink = By.xpath("//*[text()='Logout']");
	
	public void VerifyHomePage() throws Exception
	{
		try
		{
			String homepageurl = action.GetTitle();
			System.out.println("Home Page Title "+ homepageurl);
			Assert.assertEquals(homepageurl, "OrangeHRM");
			
		}
		catch(Exception e)
		{
			System.out.println("Verify Home Page failed ude to "+ e);
			throw e;
		}
	}
	
	public void Logout() throws Exception
	{
		try
		{
			action.WaitVisible(welcomeadminlink);
			action.WaitUntilElementClickable(welcomeadminlink);
			action.Click(welcomeadminlink);
			action.WaitUntilElementClickable(logoutlink);
			action.Click(logoutlink);
			
		}
		catch(Exception e)
		{
			System.out.println("Logout failed due to "+ e);
			throw e;
		}
	}

}
