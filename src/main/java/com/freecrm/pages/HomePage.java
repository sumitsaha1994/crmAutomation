package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.Util;

public class HomePage extends TestUtil{

	
	@FindBy(xpath = "//div[text() = 'Deals Summary']") public WebElement lblDealsSummaryTitle;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHomePageOpened() {
		
		if (Util.exists(driver, lblDealsSummaryTitle, 15)) {
			reporter.logStatus(stepLogger, Status.PASS, "Home Page has been opened successfully", Util.captureScreenshot(driver, reportFolderpath));
			return true;
		}else {
			reporter.logStatus(stepLogger, Status.FAIL, "Home Page was opened successfully", Util.captureScreenshot(driver, reportFolderpath));
			return false;
		}
		
	}	
	
	
}
