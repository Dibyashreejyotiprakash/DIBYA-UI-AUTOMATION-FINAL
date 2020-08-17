package com.uiautomation.filereader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader {

	
	String filepath=PropertyReader.readProperty("excelfilepath");
	
	public String readExcel(String Sheetname,int rownum,int colnum) throws Exception 
	{
		String data="";
		try
		{
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(Sheetname);
			Row row=sh.getRow(rownum);
			data=row.getCell(colnum).getStringCellValue();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + filepath);
		}
		return data;
		
	}
}
