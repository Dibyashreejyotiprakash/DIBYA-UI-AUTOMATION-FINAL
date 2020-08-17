package com.uiautomation.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.uiautomation.core.Base;




public class ScreenshotUtility extends Base {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			
			Thread.sleep(10000);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
		    System.setProperty("org.uncommons.reportng.escape-output", "false");
		    File destinationPath=new File("./resources/screenshots/" + screenshotName + ".png");
		    FileUtils.copyFile(source,destinationPath );
		    Reporter.log("<br/><a href='"+ destinationPath.getAbsolutePath() + "'>View Screenshot</a><br/>");

		} catch (Exception e) {
			e.printStackTrace();
            ExtentReport.logFailWithError("Application lunched successfully", e);
		}
	}
}
