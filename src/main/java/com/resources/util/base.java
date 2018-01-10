package com.resources.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//remote.selenium 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.meridian.test.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.objectrepository.util.AnnouncementsPage;
import com.objectrepository.util.HomePage;
import com.objectrepository.util.LoginPage;
import com.objectrepository.util.LogoutPage;

public class base {

	//public WebDriver driver;
//	public ExtentReports report;
//	public ExtentTest logger;
//	public Logger log = LogManager.getLogger(base.class.getName());

//	protected LoginPage loginPage;
//	protected HomePage homePage;
//	protected AnnouncementsPage annPage;
//	protected LogoutPage logoutPage;

//	@BeforeTest
//	public void initializeDriver() {
//		driver = Browser.GetDriver();
//	//	if (driver != null) {
//			//loginPage = new LoginPage(driver);
//			//homePage = new HomePage(driver);
//			//annPage = new AnnouncementsPage(driver);
//			//logoutPage = new LogoutPage(driver);
//	//	}
//	}

//	public void LogForPass(String name, String testname, String message) {
//		if (report == null)
//			report = new ExtentReports("./Reports/ExecutionReport_" + name + ".html");
//
//		logger = report.startTest(testname);
//		logger.log(LogStatus.PASS, message);
//		report.endTest(logger);
//
//		log.info("This test is passed as : Announcement is Created");
//		log.info("This test is passed as : Announcement is Approved");
//	}
//
//	public void LogForFail(String name, String testname, Exception e) throws IOException {
//
//		Screenshot.failedStepsScreenshot(this.driver, "FailedCase");
//
//		if (report == null)
//			report = new ExtentReports("./Reports/ExecutionReport_" + name + ".html");
//
//		logger = report.startTest(testname);
//		log.info("This test is Failed as : Announcement is not created as Failed");
//		logger.log(LogStatus.FAIL, e.getMessage());
//		report.endTest(logger);
//	}

 
}
