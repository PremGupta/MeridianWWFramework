package com.meridian.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLogs {

	public static ExtentReports report;
	public static ExtentTest logger;
	public static Logger log; 

	public static void pass(String classname, String testname, String message) throws IOException  {
		if (report == null)
			report = new ExtentReports("./Reports/ExecutionReport_" + classname + ".html");
		
		logger = report.startTest(testname);
 
		logger.log(LogStatus.PASS, message);
		report.endTest(logger);
		report.flush();
		
		//Screenshot.passedStepsScreenshot(driver, testname); 
		
		if (log == null)  
			log = LogManager.getLogger(classname);
		 
		log.info("This test is Passes as : "+testname+"is PASSED");
	}
	
	public static void fail(String classname, String testname, Throwable e) throws IOException {
		if (report == null)
			report = new ExtentReports("./Reports/ExecutionReport_" + classname + ".html");
		
		logger = report.startTest(testname);
		logger.log(LogStatus.FAIL, e.getMessage());
		report.endTest(logger);
		report.flush();
		
		//Screenshot.failedStepsScreenshot(driver, testname);
		
		if (log == null)  
			log = LogManager.getLogger(classname);
		log.info("This test is Failed as : "+testname+"is FAILED");
	}
}
