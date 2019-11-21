package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.Util;

public class LoginPage extends TestUtil{
	
	@FindBy(xpath = "//input[@name = 'email']") public WebElement txtEmailAddress;
	@FindBy(xpath = "//input[@name = 'password']") public WebElement txtPassword;
	@FindBy(xpath = "//div[text()=\"Login\"]") public WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoginPageOpened() {
		
		if(Util.exists(driver, txtEmailAddress, 20)) {
			reporter.logStatus(stepLogger, Status.PASS, "Login Page has been opened successfully", Util.captureScreenshot(driver, reportFolderpath));
			return true;
		}else {
			reporter.logStatus(stepLogger, Status.FAIL, "Login Page was not opened successfully", Util.captureScreenshot(driver, reportFolderpath));
			return false;
		}	
	}
	
	public HomePage login(String username, String password) {
		txtEmailAddress.sendKeys(username);
		txtPassword.sendKeys(password);
		reporter.logStatus(stepLogger, Status.INFO, "Enter username, password and click login button ", Util.captureScreenshot(driver, reportFolderpath));
		btnLogin.click();
		return new HomePage();
	}
	
}
