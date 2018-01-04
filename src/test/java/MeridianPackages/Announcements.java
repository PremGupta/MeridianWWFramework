package MeridianPackages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ObjectRepository_Announcements.AnnouncementsPage;
import ObjectRepository_Announcements.HomePage;
import ObjectRepository_Announcements.loginPage;
import resources.base;

public class Announcements extends base {
	
	public ExtentReports report;
	public ExtentTest logger;

	public static WebDriver driver;
	public static int randomnumber;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}
	
	@Test()

	public void AnnouncementCreation_Framework()
			throws IOException, InterruptedException {
		
		report=new ExtentReports("./Reports/ExecutionReport_AnnouncementCreation_Framework.html");
		logger=report.startTest("Start Testing: AnnouncementCreation_Framework");
		
		loginPage lp = new loginPage(driver);
		HomePage hp = new HomePage(driver);
		AnnouncementsPage ap = new AnnouncementsPage(driver);
		
		
		try {
			lp.EnterUname();
			lp.EnterPassword();
			lp.ClickLoginButton();
			hp.ClickAdmin();
			hp.ClickAnnouncement();
			ap.ClickCreateNewAnnouncement();
			ap.EnterAnnouncementTitle();
			ap.ClickFromDate();
			ap.SelectStartDate();
			ap.ClickThruDate();
			ap.SelectEndDate();
			ap.SelectCheckbox();

			Thread.sleep(10000);

			WebElement iframeElement = ap.IFrame();
			driver.switchTo().frame(iframeElement);
			driver.findElement(By.xpath("html/body/p")).click();
			//act1.moveToElement(driver.findElement(By.xpath("html/body/p"))).build().perform();
		//	act1.doubleClick(driver.findElement(By.xpath("html/body/p"))).sendKeys("shhdshaas").build().perform();
			driver.switchTo().defaultContent();

			ap.Submit().click();

			Thread.sleep(5000);
			assertEquals(
					driver.findElement(By.xpath("//*[@id=\'announcement\']/div/div/div[1]/ul/li[1]/span")).getText(),
					"Test123" + randomnumber);
			System.out.println("Test123" + randomnumber);
			log.info("This test is passed as : " + "Test123" + randomnumber + " is created");
			Screenshot.getscreenshot(driver, randomnumber);

			Thread.sleep(5000);
			WebElement Approved = ap.Approved();
			//act1.moveToElement(Approved).build().perform();
			//act1.moveToElement(Approved).click();
			log.info("This test is passed as : " + "Test123" + randomnumber + " is Approved");
			logger.log(LogStatus.PASS, "Test Verified_AnnouncementCreation_Framework: PASSED");
			report.endTest(logger);
			report.flush();
		}

		catch (Exception e) {
			Screenshot.failedStepsScreenshot(driver, randomnumber);
			log.info("This test is Failed as : " + "Test123" + randomnumber + " is not created as Failed");
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Test Verified_AnnouncementCreation_Framework: FAILED");
			report.endTest(logger);
			report.flush();
		}

	}
	

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}


}