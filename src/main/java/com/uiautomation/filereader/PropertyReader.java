package com.uiautomation.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
FileInputStream fis;
	
	public static Properties prop;
	//public static String  filepath = "\\resources\\commondata.properties";
	
	public static String readProperty(String keyword) 
	{
		FileInputStream fis;
		String  filepath = "./resources/commondata.properties";
			try
			{
				File file=new File(filepath);
				fis=new FileInputStream(file);
				prop=new Properties();
				prop.load(fis);
				prop.getProperty(keyword);
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("configuration.properties not found at " + filepath);
			}
			return prop.getProperty(keyword);
	}

}
