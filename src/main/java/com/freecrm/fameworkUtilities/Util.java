package com.freecrm.fameworkUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	public static String systemDirectory = System.getProperty("user.dir");
	public static String configLoaderFilePath = systemDirectory + "\\src\\main\\java\\com\\freecrm\\config\\config.properties";
	public static String extentConfigFilePath = systemDirectory + "\\src\\main\\java\\com\\freecrm\\config\\extent-config.xml";
	public static String dataSheetFolderPath = systemDirectory + "\\Data";
	
	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 10;
	
	
	public static boolean exists(WebDriver driver, WebElement element, int time) {
		boolean flag = true;
		WebDriverWait w = new WebDriverWait(driver, time);
		try {
			w.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public static void createFolder(String folderPath) {
		File folder = new File(folderPath);
		if(!folder.exists()) {
			folder.mkdir();
		}
		
	}
	
	public static String captureScreenshot(WebDriver driver, String folderPath){
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm_ss");
		String fileName = "Img_" + dtf.format(LocalDateTime.now()) + ".png";
		String filePath = folderPath + "\\" + ConfigLoader.prop.getProperty("screenshotspath") + "\\" + fileName;
		
		try {
			FileUtils.copyFile(src, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ConfigLoader.prop.getProperty("screenshotspath") + "\\" + fileName;
	}
	
	public static Map<String, String> getRowFromDataSheet(String sheetPath, int rowNum) {
		
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new File(sheetPath));
			XSSFSheet sht = wb.getSheetAt(0);
			Map<String, String> rowMap = new LinkedHashMap<String, String>();
			int lastColNum = sht.getRow(0).getLastCellNum();
			for(int i = 0; i < lastColNum; i++) {
				
				if(sht.getRow(rowNum).getCell(i).getCellType() == CellType.STRING) {
					rowMap.put(sht.getRow(0).getCell(i).getStringCellValue(), sht.getRow(rowNum).getCell(i).getStringCellValue());
				}else if(sht.getRow(rowNum).getCell(i).getCellType() == CellType.NUMERIC) {
					rowMap.put(sht.getRow(0).getCell(i).getStringCellValue(), Double.toString(sht.getRow(rowNum).getCell(i).getNumericCellValue()));
				}
			}
			wb.close();
			return rowMap;
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
