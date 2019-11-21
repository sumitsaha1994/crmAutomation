package com.freecrm.fameworkUtilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {

	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	
	public Reporter(String filePath) {
		htmlReporter = new ExtentHtmlReporter(filePath);
		//htmlReporter.config().setAutoCreateRelativePathMedia(true);
		htmlReporter.loadXMLConfig(Util.extentConfigFilePath);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	public ExtentReports getExtentReport() {
		return extent;
	}
	
	public void logStatus(ExtentTest logger, Status status, String logMsg, String screenShotPath) {
		try {
			logger.log(status, logMsg, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
