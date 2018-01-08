package MeridianPackages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository_Announcements.AnnouncementsPage;
import ObjectRepository_Announcements.HomePage;
import ObjectRepository_Announcements.LoginPage;
import resources.base;

public class Announcements extends base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test()

	public void AnnouncementCreation_Framework() throws IOException, InterruptedException {

		report = new ExtentReports("./Reports/ExecutionReport_AnnouncementCreation_Framework.html");
		logger = report.startTest("Start Testing: AnnouncementCreation_Framework");

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		AnnouncementsPage annPage = new AnnouncementsPage(driver);

		try {

			loginPage.Login();
			homePage.AnnouncementCreation();
			annPage.CreateAnnouncement();
			LogForPass();
		}

		catch (Exception e) {
		    Screenshot.failedStepsScreenshot(driver, annPage.randomnumber);
			LogForFail(e);
		}

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}

}