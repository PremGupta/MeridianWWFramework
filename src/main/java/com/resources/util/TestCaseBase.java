package com.resources.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.resources.util.Browser;
import com.resources.util.ReportLogs;

public class TestCaseBase {

	public WebDriver driver;

	@BeforeMethod
	public void initializeDriver() {
		System.out.print("Browser created");
		driver = Browser.GetDriver();
	}
	
	@AfterMethod
	public void teardown() {
		//ReportLogs.log.info("tEST IS COMPLETED");
		System.out.print("Browser destroyed");
		driver.close();
		driver = null;
	}

	@AfterClass
	public void cleanUP() {
	//	if (ReportLogs.report != null)
		//	ReportLogs.report.flush();
		ReportLogs.report = null;
		ReportLogs.logger = null;
		ReportLogs.log = null;
	}
}
