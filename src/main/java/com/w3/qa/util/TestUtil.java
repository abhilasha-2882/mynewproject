package com.w3.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w3.qa.base.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Abhilasha\\eclipse-workspace\\New_Project\\src\\main\\java\\com\\w3\\qa\\testdata\\demoqatestdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException
	{
		FileInputStream file=null;
		
		try
		{
			
			file =new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet =book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				
				Cell cell = sheet.getRow(i+1).getCell(k);
				if (cell == null) {
				    data[i][k] = "";
				} else {
				    switch (cell.getCellType()) {
				        case STRING:
				            data[i][k] = cell.getStringCellValue();
				            break;
				        case NUMERIC:
				            // If your test method expects int, cast accordingly
				            data[i][k] = (int) cell.getNumericCellValue();
				            break;
				        case BOOLEAN:
				            data[i][k] = cell.getBooleanCellValue();
				            break;
				        default:
				            data[i][k] = cell.toString();
				    }
				}

				
				
			}
		}
	  return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		String currentDir=System.getProperty("user.dir");
		File srcFile=((TakesScreenshot)e_driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+".png"));
	}
		
	
}
