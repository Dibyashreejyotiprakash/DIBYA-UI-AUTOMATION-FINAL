package com.uiautomation.filereader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.JsonPath;

public class JsonReader {
	
	public static String getdatafromjson(String path) {
		String result="";
		String filepath = PropertyReader.readProperty("jsonfilepath");
		try {
			File f = new File("");
			String json = FileUtils.readFileToString(f, "UTF-8");
			result = JsonPath.read(json, path);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + filepath);
		}
		return result;
	}

}
