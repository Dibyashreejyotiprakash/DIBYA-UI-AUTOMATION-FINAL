package com.uiautomation.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtility {

	public static void closeAuthenticationPopUp() throws AWTException, InterruptedException {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);

		}
		catch(Exception e) {
			e.printStackTrace();
            ExtentReport.logFailWithError("Close Authentication PopUp failed due to :", e);
		}
	}
	
	
	public static void uploadFile(String filepath) throws AWTException, InterruptedException {
		try {
			StringSelection ss = new StringSelection(filepath);
			Thread.sleep(5000);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
			Thread.sleep(5000);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(5000);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(5000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e) {
			e.printStackTrace();
            ExtentReport.logFailWithError("Upload file failed due to :", e);
		}
	}

}
