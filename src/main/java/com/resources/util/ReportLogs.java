package com.resources.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.meridian.test.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLogs {

	public static ExtentReports report;
	public static ExtentTest logger;
	public static Logger log; // = LogManager.getLogger(base.class.getName());

	public static void Pass(String classname, String testname, String message, WebDriver driver) throws IOException  {
		if (report == null)
			report = new ExtentReports("./Reports/ExecutionReport_" + classname + ".html");

		logger = report.startTest(testname);
		logger.log(LogStatus.PASS, message);
		report.endTest(logger);
		report.flush();
		Screenshot.passedStepsScreenshot(driver, testname); 
	}
	
	public static void Fail(String classname, String testname, Exception e, WebDriver driver) throws IOException {
		if (report == null)
			report = new ExtentReports("./Reports/ExecutionReport_" + classname + ".html");

		logger = report.startTest(testname);
		logger.log(LogStatus.FAIL, e.getMessage());
		report.endTest(logger);
		report.flush();
		Screenshot.failedStepsScreenshot(driver, testname);
	}
}
