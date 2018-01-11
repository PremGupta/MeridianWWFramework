package com.meridian.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.meridian.page.AnnouncementsPage;
import com.meridian.page.HomePage;
import com.meridian.page.LoginPage;
import com.meridian.page.LogoutPage;
import com.meridian.util.Browser;
import com.meridian.util.ReportLogs;

public class TestCaseBase {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public AnnouncementsPage annPage;
	public LogoutPage logoutPage;

	@BeforeMethod
	public void setup() {
		System.out.print("Browser created");
		this.driver = Browser.getDriver();		
		loginPage = new LoginPage(this.driver);
		homePage = new HomePage(this.driver);
		annPage = new AnnouncementsPage(driver);
		logoutPage = new LogoutPage(this.driver);
	}
	
	@AfterMethod
	public void teardown() {
		
		System.out.print("Browser destroyed");
		driver.close();
		driver.quit();

	}

	@AfterClass
	public void cleanUP() {
		ReportLogs.report = null;
		ReportLogs.logger = null;
		ReportLogs.log = null;
	}
}
