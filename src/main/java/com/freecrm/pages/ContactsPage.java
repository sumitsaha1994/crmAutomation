package com.freecrm.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.Util;

public class ContactsPage extends TestUtil{
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black' and text()='Contacts']") public WebElement lblContacts;
	@FindBy(xpath = "//table[@class='ui celled sortable striped table custom-grid table-scroll']") public WebElement tblContacts;
	
	@FindBy(xpath = "//button[text()='New']") public WebElement btnNew;
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black' and text()='Create New Contact']") public WebElement lblCreateNewContact;
	
	@FindBy(xpath = "//button[text()='Export']") public WebElement btnExport;
	@FindBy(xpath = "//button[@class='ui primary button' and text() = 'OK']") public WebElement btnExportAlertOk;
	
	@FindBy(xpath = "//input[@name='first_name']") public WebElement txtFirstName;
	@FindBy(xpath = "//input[@name='middle_name']") public WebElement txtMiddleName;
	@FindBy(xpath = "//input[@name='last_name']") public WebElement txtLastName;
	@FindBy(xpath = "//div[@name='company']//input[@class='search']") public WebElement txtCompany;
	@FindBy(xpath = "//div[@name='company']//div[contains(@class,'selected item')]") public WebElement txtCompanySearchOption;
	@FindBy(xpath = "//div[@name='company']//i[@class='search icon']") public WebElement btnCompanySearch;
	//@FindBy(xpath = "//div[@class='ui fluid multiple search selection dropdown']//input[@class='search']") public WebElement txtTags;
	@FindBy(xpath = "//label[@for='tags']//input") public WebElement txtTags;
	@FindBy(xpath = "//label[@for='tags']//i[@class='search icon']") public WebElement btnTagsSearch;
	@FindBy(xpath = "//div[@class='three fields'][1]//div[@class='ui right corner labeled input']//input[@name='value']") public WebElement txtEmail1;
	
	@FindBy(xpath = "//button[@class='ui linkedin button' and text()='Save']") public WebElement btnSave; 
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isContactsPageOpened() {
		if (Util.exists(driver, lblContacts, 10)) {
			reporter.logStatus(stepLogger, Status.PASS, "Contacts form has been opened", Util.captureScreenshot(driver, reportFolderpath));
			return true;
		}else {
			reporter.logStatus(stepLogger, Status.FAIL, "Contacts form was opened", Util.captureScreenshot(driver, reportFolderpath));
			return false;
		}
	}	
	
	public void navigateToCreateNewContactForm() {
		reporter.logStatus(stepLogger, Status.INFO, "clcik on new button to navigate to create new contact form", Util.captureScreenshot(driver, reportFolderpath));
		btnNew.click();
	}
	
	public boolean isCreateNewContactFormOpened() {
		
		if (Util.exists(driver, lblCreateNewContact, 10)) {
			reporter.logStatus(stepLogger, Status.PASS, "Create New Contact form has been opened", Util.captureScreenshot(driver, reportFolderpath));
			return true;
		}else {
			reporter.logStatus(stepLogger, Status.FAIL, "Create New Contact form was opened", Util.captureScreenshot(driver, reportFolderpath));
			return false;
		}
	}
	
	public void fillCreateNewContactFormDataandSave(Map<String, String> data) {
		//for(Map.Entry<String, String> entry : data.entrySet() ) {}
		
		txtFirstName.sendKeys(data.get("FirstName"));
		txtMiddleName.sendKeys(data.get("MiddleName"));
		txtLastName.sendKeys(data.get("LastName"));
		txtCompany.sendKeys(data.get("Company"));
		//txtCompanySearchOption.click();
		//txtCompany.sendKeys(Keys.ENTER);
		btnCompanySearch.click();
		txtTags.sendKeys(data.get("Tags"));
		btnTagsSearch.click();
		txtEmail1.sendKeys(data.get("Email"));
		
		reporter.logStatus(stepLogger, Status.PASS, "Enter Contact data", Util.captureScreenshot(driver, reportFolderpath));
		
		btnSave.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean exportContacts() {
		boolean returnFlag = true;
		List<WebElement> tableRows = tblContacts.findElements(By.xpath("//tbody/tr"));
		if(tableRows.size() == 0) {
			reporter.logStatus(stepLogger, Status.FAIL, "No records found in contacts table", Util.captureScreenshot(driver, reportFolderpath));
			returnFlag = false;
		}else {
			reporter.logStatus(stepLogger, Status.PASS, tableRows.size() + " record(s) found in contacts table, Export will start soon", Util.captureScreenshot(driver, reportFolderpath));
			btnExport.click();
			if(Util.exists(driver, btnExportAlertOk, 5)) {
				reporter.logStatus(stepLogger, Status.PASS, "Click on Ok button", Util.captureScreenshot(driver, reportFolderpath));
				btnExportAlertOk.click();
			}else {
				returnFlag = false;
				reporter.logStatus(stepLogger, Status.FAIL, "Export alert's Ok button was not displayed", Util.captureScreenshot(driver, reportFolderpath));
			}
				
		}
		return returnFlag;
	}
}
