package com.resources.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener  {
TestCaseBase b=new TestCaseBase();
	public void onFinish(ITestContext arg0) {

	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	public void onTestFailure(ITestResult result) {

	}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult arg0) {
	}

}
