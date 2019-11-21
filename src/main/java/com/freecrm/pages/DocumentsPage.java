package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.Util;

public class DocumentsPage extends TestUtil{
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black' and text()='Documents']") public WebElement lblDocumentsHeading;
	@FindBy(xpath = "//a[contains(text(),'Exports')]") public WebElement lnkExportsFolder;
	@FindBy(xpath = "//div[@class='ui cards']/div[1]//div[@class='extra content']/div[@class = 'file right-floated']") public WebElement btnExportContactDownload;
	
	public DocumentsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDocumentsPageOpened() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Util.exists(driver, lblDocumentsHeading, 10)) {
			reporter.logStatus(stepLogger, Status.PASS, "Documents Page has been opened", Util.captureScreenshot(driver, reportFolderpath));
			return true;
		}else {
			reporter.logStatus(stepLogger, Status.FAIL, "Documents Page was not opened", Util.captureScreenshot(driver, reportFolderpath));
			return false;
		}
	}
	
	public void downloadLatestExport() {
		lnkExportsFolder.click();
		if(Util.exists(driver, btnExportContactDownload, 10)) {
			reporter.logStatus(stepLogger, Status.PASS, "Exports card is displayed", Util.captureScreenshot(driver, reportFolderpath));
			btnExportContactDownload.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			reporter.logStatus(stepLogger, Status.PASS, "Exports card was not displayed", Util.captureScreenshot(driver, reportFolderpath));	
		}
	}
}
