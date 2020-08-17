package com.uiautomation.tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.uiautomation.core.Base;
import com.uiautomation.filereader.JsonReader;
import com.uiautomation.pageobjects.HomePage;
import com.uiautomation.pageobjects.LoginPage;
import com.uiautomation.utilities.BuildUrl;
import com.uiautomation.utilities.ExtentReport;
import com.uiautomation.utilities.InteractionUtility;


public class VerifyLoginTest2 extends Base
{
	
	
	InteractionUtility action = new InteractionUtility(driver);
	@Test(priority=1)
	public void verifyLogin2(Method result) throws IOException, ParseException
	{
		System.out.println("Test-3");
		ExtentReport.extentlog = ExtentReport.extentreport.startTest(result.getName(),"Verify Login");
		BuildUrl.lunchURL("INSTANTIMPACT");
		ExtentReport.logInfo("Application lunched successfully");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "OrangeHRM");
		
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Test-4");
	}
	
	
	
	
	
}
