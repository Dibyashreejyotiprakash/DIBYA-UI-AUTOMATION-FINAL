package com.uiautomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.uiautomation.core.Base;
import com.uiautomation.core.ConfigurationManager;
import com.uiautomation.enums.BusinessUnit;
import com.uiautomation.enums.Environment;
import com.uiautomation.filereader.PropertyReader;

public class BuildUrl extends Base{
	
	
	public String environment= PropertyReader.readProperty("environment");
	
	public  static void lunchURL(String applicationame) {
		String applicationurl= PropertyReader.readProperty("applicationurl");
        try
        {
        	ConfigurationManager config = new ConfigurationManager();
        	BusinessUnit businessunitname= config.getBusinessUnitName();
        	Environment environmentname = config.getEnvironmentName();
        	
        	switch(businessunitname) {
        		case INSTANTIMPACT : 
        			switch(environmentname) {
        				case UAT:
        				driver.get(applicationurl);
        				driver.manage().window().maximize();
        				case STAGE:
        				driver.get(applicationurl);
        				driver.manage().window().maximize();
        				case PROD:
        				driver.get(applicationurl);
        				driver.manage().window().maximize();
        				break;
        		 }
    	    	break;
            case DESIGNTRACKER : 
            	switch(environmentname) {
					case UAT:
						driver.get(applicationurl);
						driver.manage().window().maximize();
					case STAGE:
						driver.get(applicationurl);
						driver.manage().window().maximize();
					case PROD:
						driver.get(applicationurl);
						driver.manage().window().maximize();
						break;
            		}
        		break;
            case WSWADMIN : 
            	switch(environmentname) {
					case UAT:
						driver.get(applicationurl);
						driver.manage().window().maximize();
					case STAGE:
						driver.get(applicationurl);
						driver.manage().window().maximize();
					case PROD:
						driver.get(applicationurl);
						driver.manage().window().maximize();
				break;
            	}
        		break;
        	}
        }
        catch(Exception e)
        {
            e.printStackTrace();
            ExtentReport.logFailWithError("Application lunched successfully", e);
        }
		
	}

}
