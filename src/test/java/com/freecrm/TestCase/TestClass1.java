package com.freecrm.TestCase;

import java.time.LocalDateTime;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.TestUtilities.TestUtil;
import com.freecrm.fameworkUtilities.ConfigLoader;
import com.freecrm.fameworkUtilities.Util;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.DocumentsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LaunchPage;
import com.freecrm.pages.LoginPage;
import com.freecrm.pages.NavigationPane;

public class TestClass1 extends TestUtil{
	LaunchPage launchPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DocumentsPage documentsPage;
	NavigationPane navigator;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@Test
	public void verify_login() {
		execFlag = true;
		testLogger = extent.createTest("verify_login");
		
		//---Step - 1 - 'Launch URL' starts
		stepLogger = testLogger.createNode("Step - 1 : Launch URL");
		launchUrl(ConfigLoader.prop.getProperty("url"));
		launchPage = new LaunchPage();
		execFlag = launchPage.isLaunchPageOpened();
		//---Step - 1 - 'Launch URL' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 2 - 'Navigate to Login page' starts
		stepLogger = testLogger.createNode("Step - 2 : Navigate to Login page");
		loginPage = launchPage.navigateToLoginPage();
		execFlag = loginPage.isLoginPageOpened();
		//Step - 2 - 'Navigate to Login page' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step -3 - 'Log in' ends
		stepLogger = testLogger.createNode("Step - 3 : Login");
		homePage = loginPage.login(ConfigLoader.prop.getProperty("username"), ConfigLoader.prop.getProperty("password"));
		execFlag = homePage.isHomePageOpened();
		//Step -3 - 'Log in' ends
	}
	
	@Test
	public void create_contact() {
		execFlag = true;
		testLogger = extent.createTest("create_contact");
		
		//---Step - 1 - 'Launch URL' starts
		stepLogger = testLogger.createNode("Step - 1 : Launch URL");
		launchUrl(ConfigLoader.prop.getProperty("url"));
		launchPage = new LaunchPage();
		execFlag = launchPage.isLaunchPageOpened();
		//---Step - 1 - 'Launch URL' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 2 - 'Navigate to Login page' starts
		stepLogger = testLogger.createNode("Step - 2 : Navigate to Login page");
		loginPage = launchPage.navigateToLoginPage();
		execFlag = loginPage.isLoginPageOpened();
		//Step - 2 - 'Navigate to Login page' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step -3 - 'Log in' ends
		stepLogger = testLogger.createNode("Step - 3 : Login");
		homePage = loginPage.login(ConfigLoader.prop.getProperty("username"), ConfigLoader.prop.getProperty("password"));
		execFlag = homePage.isHomePageOpened();
		//Step -3 - 'Log in' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 4 - add new Contacts
		
		//open contacts page
		stepLogger = testLogger.createNode("Step - 4 : Add new Contacts");
		navigator = new NavigationPane();
		contactsPage = navigator.navigateToContactsPage();
		execFlag = contactsPage.isContactsPageOpened();
		
		if(!execFlag) {
			return;
		}
		
		//open create new contact form
		contactsPage.navigateToCreateNewContactForm();
		execFlag = contactsPage.isCreateNewContactFormOpened();
		
		if(!execFlag) {
			return;
		}
		
		//Fill contact data and save the contact
		Map<String, String> rowData = Util.getRowFromDataSheet(Util.dataSheetFolderPath + "\\" + ConfigLoader.prop.getProperty("contactssheetName"), 1);
		if(rowData != null) {
			contactsPage.fillCreateNewContactFormDataandSave(rowData);
		}
		contactsPage = navigator.navigateToContactsPage();
		execFlag = contactsPage.isContactsPageOpened();
			
	}
	
	@Test
	public void export_contact() {
		execFlag = true;
		testLogger = extent.createTest("export_contact");
		
		//---Step - 1 - 'Launch URL' starts
		stepLogger = testLogger.createNode("Step - 1 : Launch URL");
		launchUrl(ConfigLoader.prop.getProperty("url"));
		launchPage = new LaunchPage();
		execFlag = launchPage.isLaunchPageOpened();
		//---Step - 1 - 'Launch URL' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 2 - 'Navigate to Login page' starts
		stepLogger = testLogger.createNode("Step - 2 : Navigate to Login page");
		loginPage = launchPage.navigateToLoginPage();
		execFlag = loginPage.isLoginPageOpened();
		//Step - 2 - 'Navigate to Login page' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step -3 - 'Log in' ends
		stepLogger = testLogger.createNode("Step - 3 : Login");
		homePage = loginPage.login(ConfigLoader.prop.getProperty("username"), ConfigLoader.prop.getProperty("password"));
		execFlag = homePage.isHomePageOpened();
		//Step -3 - 'Log in' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step 4 - Export contacts
		//open contacts page
		stepLogger = testLogger.createNode("Step - 4 : Export contacts");
		navigator = new NavigationPane();
		contactsPage = navigator.navigateToContactsPage();
		execFlag = contactsPage.isContactsPageOpened();
		
		if(!execFlag) {
			return;
		}
		//export contacts
		execFlag = contactsPage.exportContacts();
	}
	
	@Test
	public void download_exported_contact() {
		execFlag = true;
		testLogger = extent.createTest("download_exported_contact");
		
		//---Step - 1 - 'Launch URL' starts
		stepLogger = testLogger.createNode("Step - 1 : Launch URL");
		launchUrl(ConfigLoader.prop.getProperty("url"));
		launchPage = new LaunchPage();
		execFlag = launchPage.isLaunchPageOpened();
		//---Step - 1 - 'Launch URL' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 2 - 'Navigate to Login page' starts
		stepLogger = testLogger.createNode("Step - 2 : Navigate to Login page");
		loginPage = launchPage.navigateToLoginPage();
		execFlag = loginPage.isLoginPageOpened();
		//Step - 2 - 'Navigate to Login page' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step -3 - 'Log in' ends
		stepLogger = testLogger.createNode("Step - 3 : Login");
		homePage = loginPage.login(ConfigLoader.prop.getProperty("username"), ConfigLoader.prop.getProperty("password"));
		execFlag = homePage.isHomePageOpened();
		//Step -3 - 'Log in' ends
		
		if(!execFlag) {
			return;
		}
		
		//Step - 4 - download exported contact
		stepLogger = testLogger.createNode("Step - 4 : Download exported contact");
		navigator = new NavigationPane();
		documentsPage = navigator.navigateToDocumentsPage();
		execFlag = documentsPage.isDocumentsPageOpened();
		
		if(!execFlag) {
			return;
		}
		//Download exported contacts
		documentsPage.downloadLatestExport();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println(testLogger.getStatus().name());
		extent.flush();
		System.out.println("abc");
		driver.quit();
		System.out.println("after method");
	}
}
