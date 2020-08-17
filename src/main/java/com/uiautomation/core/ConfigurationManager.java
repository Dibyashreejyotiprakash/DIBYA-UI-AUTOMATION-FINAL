package com.uiautomation.core;

import org.openqa.selenium.WebDriver;

import com.uiautomation.enums.BusinessUnit;
import com.uiautomation.enums.DriverType;
import com.uiautomation.enums.Environment;
import com.uiautomation.filereader.PropertyReader;

public class ConfigurationManager {
	
	
	public DriverType getBrowser() {
		String browserName = PropertyReader.readProperty("browsername");
		if (browserName.equalsIgnoreCase("Chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Please provide valid browser value from configuration.properties file:"+browserName);
	}
	
	public BusinessUnit getBusinessUnitName() {
		String applicationName = PropertyReader.readProperty("businessunit");
		if(applicationName.equalsIgnoreCase("InstantImpact"))
			return BusinessUnit.INSTANTIMPACT;
		else if(applicationName.equalsIgnoreCase("DesignTracker"))
			return BusinessUnit.DESIGNTRACKER;
		else if(applicationName.equalsIgnoreCase("WSWAdmin"))
			return BusinessUnit.WSWADMIN;
		else 
			throw new RuntimeException("Please provide valid business unit name from commondata.properties file:"+applicationName);
	}
	
	
	public Environment getEnvironmentName() {
		String environmentname = PropertyReader.readProperty("environment");
		if(environmentname.equalsIgnoreCase("UAT"))
			return Environment.UAT;
		else if(environmentname.equalsIgnoreCase("STAGE"))
			return Environment.STAGE;
		else if(environmentname.equalsIgnoreCase("RPOD"))
			return Environment.PROD;
		else 
			throw new RuntimeException("Please provide valid environment name from commondata.properties file:"+environmentname);
	} 
	
}
