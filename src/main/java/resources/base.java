package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\WhereverWeb\\MeridianWW\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\WhereverWeb\\MeridianWW\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\WhereverWeb\\MeridianWW\\Jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "E:\\WhereverWeb\\MeridianWW\\Jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result, int randomNumber) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotname = "Test123";
		String filetype = ".png";
		String Randomscreenshotname = screenshotname + randomNumber + filetype;
		System.out.println("Failed script screenshot taken");
		System.out.println(Randomscreenshotname);

		FileUtils.copyFile(src,
				new File("C:\\Users\\Prem\\Meridian\\FailedStepsScreenshots\\" + result + "screenshot.png"));

	}
}
