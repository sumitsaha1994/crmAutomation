package com.freecrm.TestUtilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.freecrm.fameworkUtilities.BrowserFactory;
import com.freecrm.fameworkUtilities.ConfigLoader;
import com.freecrm.fameworkUtilities.Reporter;
import com.freecrm.fameworkUtilities.Util;
import com.freecrm.pages.LaunchPage;


public class TestUtil {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest testLogger;
	public static ExtentTest stepLogger;
	public static boolean execFlag = true;
	public static String reportFolderpath;
	public static Reporter reporter;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite base");
		
		//Report initialization
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		
		reportFolderpath = Util.systemDirectory + "\\" + ConfigLoader.prop.getProperty("reportspath") + "\\" + dtf2.format(now);
		Util.createFolder(reportFolderpath);
		Util.createFolder(reportFolderpath + "\\" + ConfigLoader.prop.getProperty("screenshotspath"));
		String reportFilePath = reportFolderpath + "\\Report_" + dtf1.format(now) + ".html";
		System.out.println(reportFilePath);
		reporter = new Reporter(reportFilePath);
		extent = reporter.getExtentReport();
	}
	
	@BeforeTest
	public void beforeTest() {
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite base");
		//driver.quit();
	}
	
	public static void launchUrl(String url) {
		//Driver initialization
		driver = new BrowserFactory().getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
	}
}
