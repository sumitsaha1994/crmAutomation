package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.Util;

public class NavigationPane extends TestUtil{

	
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Home')]") public WebElement lnkHome;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Calendar')]") public WebElement lnkCalendar;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Contacts')]") public WebElement lnkContacts;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Companies')]") public WebElement lnkCompanies;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Deals')]") public WebElement lnkDeals;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Tasks')]") public WebElement lnkTasks;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Calls')]") public WebElement lnkCalls;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Documents')]") public WebElement lnkDocuments;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Email')]") public WebElement lnkEmail;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Campaigns')]") public WebElement lnkCampaigns;
	@FindBy(xpath = "//div[@id='main-nav']/a/span[contains(text(),'Forms')]") public WebElement lnkForms;
	
	public NavigationPane() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage navigateToHomePage() {
		lnkHome.click();
		return new HomePage();
	}
	
	
	public ContactsPage navigateToContactsPage() {
		if(Util.exists(driver, lnkContacts, 15)) {
			lnkContacts.click();
			reporter.logStatus(stepLogger, Status.PASS, "Click on Contacts", Util.captureScreenshot(driver, reportFolderpath));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			reporter.logStatus(stepLogger, Status.PASS, "Contacts link not found", Util.captureScreenshot(driver, reportFolderpath));
		}
		return new ContactsPage();
	}
	
	public DocumentsPage navigateToDocumentsPage() {
		if(Util.exists(driver, lnkDocuments, 15)) {
			lnkDocuments.click();
			reporter.logStatus(stepLogger, Status.PASS, "Click on Contacts", Util.captureScreenshot(driver, reportFolderpath));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			reporter.logStatus(stepLogger, Status.PASS, "Contacts link not found", Util.captureScreenshot(driver, reportFolderpath));
		}
		return new DocumentsPage();
	}
}
