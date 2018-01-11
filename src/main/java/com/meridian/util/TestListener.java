package com.meridian.util;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ReportLogs.fail(result.getTestClass().getName(), result.getMethod().getMethodName(), result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// logger.error(String.format("FAIL %s.%s", result.getTestClass().getName(),
		// result.getMethod().getMethodName()));
		try {
			ReportLogs.pass(result.getTestClass().getName(), result.getMethod().getMethodName(), "Test succeeded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
