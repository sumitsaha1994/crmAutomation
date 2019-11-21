package com.freecrm.fameworkUtilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private WebDriver driver;
	
	public BrowserFactory() {
		if(ConfigLoader.prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			/* Create a new FireFox Profile instance. */
			FirefoxProfile ffProfile = new FirefoxProfile();
			 
			/* Set file save to directory. */
			ffProfile.setPreference("browser.download.dir", Util.systemDirectory + "\\" + ConfigLoader.prop.getProperty("downloadsfolderpath"));
			ffProfile.setPreference("browser.download.folderList", 2);
			 
			/* Set file mime type which do not show save to popup dialog.
			 * If the file format is zip, then we set this
			 * preference's value to application/zip. If file format is csv then
			 * you need set the value to application/csv.
			 *  */
			ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip;"); 
			
			/* If download pdf.*/
			ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;");
			ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
			 
			ffProfile.setPreference( "browser.download.manager.showWhenStarting", false );
			ffProfile.setPreference( "pdfjs.disabled", true );
			
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(ffProfile);
			
			driver = new FirefoxDriver(options);
		}else if(ConfigLoader.prop.getProperty("browser").equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
