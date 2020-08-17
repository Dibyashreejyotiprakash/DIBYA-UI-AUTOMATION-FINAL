package com.uiautomation.utilities;

import java.io.File;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.uiautomation.filereader.PropertyReader;


public class ExtentReport {

	public static ExtentReports extentreport = null;
	public static ExtentTest extentlog;
	

	public static void initialize(String path) {
		if (extentreport == null) {
			extentreport = new ExtentReports(path, true);
			extentreport.addSystemInfo("Host Name", System.getProperty("user.name"));
			extentreport.addSystemInfo("Environment", PropertyReader.readProperty("environment"));
			extentreport.loadConfig(new File(System.getProperty("user.dir") + "/resources/extent-config.xml"));
		}
	}

	public static void setinstanceNull() {
		extentreport = null;
	}
	
	public static void logInfo(String message) {

		extentlog.log(LogStatus.INFO, message);
	}

	public static void logError(String message) {
		extentlog.log(LogStatus.ERROR, message);
	}
	
	public static void logFail(String message) {
		extentlog.log(LogStatus.FAIL, message);
	}
	
	public static void logFailWithError(String message,Exception e) {
		extentlog.log(LogStatus.FAIL, message, e);
	}
	
}
