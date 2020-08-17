package com.uiautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.uiautomation.core.Base;
import com.uiautomation.utilities.InteractionUtility;



public class LoginPage extends Base
{
	InteractionUtility action;
	public LoginPage(WebDriver driver)
	{
		driver = this.driver;
		action = new InteractionUtility(driver);
	}
	
	public static By txtusername = By.xpath("//*[@id='txtUsername']");
	public static By txtpassword = By.xpath("//*[@id='txtPassword']");
	public static By loginbtn = By.xpath("//*[@id='btnLogin']");
	
	@Test
	public void VerifyLogin() throws Exception
	{
		try
		{
			action.Type(txtusername, "Admin");
			action.Type(txtpassword,"admin123");
			action.Click(loginbtn);
		}
		catch(Exception e)
		{
			System.out.println("Verify Login failed due to "+ e);
			throw e;
		}
		
		
	}
	
}
