package com.uiautomation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.uiautomation.enums.DriverType;
import com.uiautomation.filereader.PropertyReader;


public class DriverManager {
	
	public WebDriver driver;
	private DriverType driverType;
	ConfigurationManager configurationManager=new ConfigurationManager();
    
    public DriverManager() {
    	
    	driverType=configurationManager.getBrowser();
    }

    public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;

    }

    public WebDriver createDriver() {
    	
        switch (driverType) {	    
        case FIREFOX : 
        	FirefoxOptions firefoxOptions=new FirefoxOptions();
        	firefoxOptions.setAcceptInsecureCerts(true);
        	firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	firefoxOptions.addArguments("use-fake-ui-for-media-stream");
        	firefoxOptions.addPreference("media.navigator.permission.disabled",true);
        	System.setProperty("webdriver.firefox.driver",PropertyReader.readProperty("firefoxdriverpath"));
        	driver = new FirefoxDriver(firefoxOptions);
	    	break;
        case CHROME : 
        	System.setProperty("webdriver.chrome.driver",PropertyReader.readProperty("chromedriverpath"));
        	ChromeOptions options = new ChromeOptions();
        	options.setAcceptInsecureCerts(true);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.addArguments("use-fake-ui-for-media-stream");
            options.addArguments("test");
            
        	driver = new ChromeDriver(options);
    		break;
        case INTERNETEXPLORER : 
        	System.setProperty("webdriver.ie.driver",PropertyReader.readProperty("iedriverpath"));
        	driver = new InternetExplorerDriver();
    		break;
    		
		default:
			System.setProperty("webdriver.chrome.driver",PropertyReader.readProperty("chromedriverpath"));
        	driver = new ChromeDriver();
        	break;
        }

		return driver;

    }
    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
