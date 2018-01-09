package resources;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import MeridianPackages.Screenshot;
import ObjectRepository_Announcements.AnnouncementsPage;
import ObjectRepository_Announcements.HomePage;
import ObjectRepository_Announcements.LoginPage;
import ObjectRepository_Announcements.LogoutPage;

public class base {

	public static WebDriver driver;
	public Properties prop;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Logger log = LogManager.getLogger(base.class.getName());

	protected LoginPage loginPage;
	protected HomePage homePage;
	protected AnnouncementsPage annPage;
	protected LogoutPage logoutPage;

	@BeforeTest
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("./data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("IE"));
			driver = new InternetExplorerDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		annPage = new AnnouncementsPage(driver);
		logoutPage = new LogoutPage(driver);

		return driver;

	}


	public void LogForPass(String name) {
		report = new ExtentReports("./Reports/ExecutionReport_" + name + ".html");
		logger = report.startTest("Start Testing: " + name);
		log.info("This test is passed as : Announcement is Created");
		log.info("This test is passed as : Announcement is Approved");
		logger.log(LogStatus.PASS, "Test Verified_AnnouncementCreation_Framework: PASSED");
		report.endTest(logger);
		report.flush();
	}

	public static void LogForFail(Exception e) throws IOException {
		Screenshot.failedStepsScreenshot(driver, AnnouncementsPage.randomnumber);
		log.info("This test is Failed as : Announcement is not created as Failed");
		logger.log(LogStatus.FAIL, "Test Verified_AnnouncementCreation_Framework: FAILED");
		logger.log(LogStatus.FAIL, e.getMessage());
		report.endTest(logger);
		report.flush();
	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;

	}
	
	public void getFailedScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new File("./FailedStepsScreenshots\\" +
		// result + ".png"));
	}

}
