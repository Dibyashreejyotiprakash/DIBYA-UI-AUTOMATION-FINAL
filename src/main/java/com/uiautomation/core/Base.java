package com.uiautomation.core;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.uiautomation.utilities.ExtentReport;
import com.uiautomation.utilities.ScreenshotUtility;
import com.uiautomation.utilities.StringUtil;


public class Base {
	
	static Date now = new Date();
	public static String TimeStamp = now.toString().replace(":", "-");
	public  static WebDriver driver;

	DriverManager driverManager = new DriverManager();
	
	
	
	@Parameters({ "ReportName", "FlowType" })
	@BeforeSuite(alwaysRun = true)
	public void config(@Optional("Optional name Automation ") String reportname, @Optional("Automation Report") String flow)
			throws IOException {
		
		ExtentReport.initialize(System.getProperty("user.dir")+"/Reports/"+ TimeStamp+" WEGUI_Report.html");

	}
	@BeforeClass
	public void beforeTest() {
		driver = driverManager.getDriver();
	}
	

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().deleteAllCookies();
	}
		
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				ExtentReport.extentlog.log(LogStatus.PASS, "Test case: " + result.getName()+" is passed " );

			} else if (result.getStatus() == ITestResult.FAILURE) {
				ExtentReport.extentlog.log(LogStatus.FAIL, "Test case: " + result.getName() + " is failed");
				ExtentReport.extentlog.log(LogStatus.FAIL, "Test case is failed " + result.getThrowable());
				String methodName=StringUtil.createRandomString(result.getMethod().getMethodName());
				ScreenshotUtility.captureScreenshot(driver,methodName);
			} else if (result.getStatus() == ITestResult.SKIP) {
				ExtentReport.extentlog.log(LogStatus.SKIP, "Test case is Skiped " );
				
			}
			ExtentReport.extentreport.endTest(ExtentReport.extentlog);
			Reporter.setCurrentTestResult(result);
	}

	@AfterClass
	public void afterTest() {
		driverManager.quitDriver();
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void endReport() {
		ExtentReport.extentreport.flush();
	}
	
	
}
