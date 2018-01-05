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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import MeridianPackages.Screenshot;

public class base {

	public static WebDriver driver;
	public Properties prop;
	public ExtentReports report;
	public ExtentTest logger;
	public static Logger log = LogManager.getLogger(base.class.getName());

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
		return driver;

	}

	public void LogForPass() {
		log.info("This test is passed as : Announcement is Created");
		log.info("This test is passed as : Announcement is Approved");
		logger.log(LogStatus.PASS, "Test Verified_AnnouncementCreation_Framework: PASSED");
		report.endTest(logger);
		report.flush();
	}

	public void LogForFail() {
		log.info("This test is Failed as : Announcement is not created as Failed");
		logger.log(LogStatus.FAIL, "Test Verified_AnnouncementCreation_Framework: FAILED");
		report.endTest(logger);
		report.flush();
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("E:\\MeridianWWFramework\\FailedStepsScreenshots\\" + result + "screenshot.png"));

	}
}
