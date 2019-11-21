package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.ConfigLoader;
import com.freecrm.fameworkUtilities.Util;

public class LaunchPage extends TestUtil{
	
	
	//Page factory - OR
	@FindBy(xpath = "//div[@class='rd-navbar-panel']//div[@class='rd-navbar-brand']/a[@title='free crm home']") WebElement lnkTitleLaunchPage;
	@FindBy(xpath = "//span[text()='CRM']") WebElement lblTitleHomePage;
	@FindBy(xpath = "//a[@href='https://ui.freecrm.com']") WebElement btnLogin;
	
	public LaunchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLaunchPageOpened() {
		
		if (Util.exists(driver, lnkTitleLaunchPage, 15)) {
			stepLogger.log(Status.PASS, "Launch Page has been opened successfully");
			return true;
		}else {
			stepLogger.log(Status.FAIL, "launch Page was not opened successfully");
			return false;
		}
		
	}
	
	public LoginPage navigateToLoginPage() {
		stepLogger.log(Status.INFO, "Click on login button to navigate to login page");
		btnLogin.click();
		return new LoginPage();
		
	}
	
}
