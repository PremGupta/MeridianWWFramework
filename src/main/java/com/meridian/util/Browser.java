package com.meridian.util;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

	public static WebDriver getDriver() {
		
		WebDriver driver = null;
		String browserName = Config.getValue("browser");
		String driverMode = Config.getValue("driverMode");
		if (driverMode.equals("local")) {
			driver = getLocalDriver(browserName);
		} else if (driverMode.equals("remote")) {
			driver = getRemoteDriver(browserName);			
		} else {
			System.out.println("Please give valid driver mode option");
		}

		return driver;
	}
	
	private static WebDriver getLocalDriver(String browserName) {
		WebDriver driver = null;
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			String path = Config.getValue("chrome");
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			String path = Config.getValue("firefox");
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();

		} else if (browserName.equals("iexplore")) {
			String path = Config.getValue("iexplore");
			System.setProperty("webdriver.ie.driver", path);
			driver = new InternetExplorerDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();

		} else {
			System.out.println("Please give valid browser option");
		}
		
		if (driver != null)
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private static WebDriver getRemoteDriver(String browserName) {
		
		RemoteWebDriver driver = null;
		try {
			String hubURL = Config.getValue("hubURL");
			DesiredCapabilities cap = null;
			
			if (browserName.equals("chrome")) {
				cap = DesiredCapabilities.chrome();
		        ChromeOptions chromeOptions = new ChromeOptions();
		        chromeOptions.addArguments("--start-maximized");
		        cap.setBrowserName("chrome");
		        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			} else if (browserName.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
		        cap.setBrowserName("firefox");	    
		        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        cap.setCapability("ensureCleanSession", true);
			} else if (browserName.equals("iexplore")) {
				cap = DesiredCapabilities.internetExplorer();
		        cap.setBrowserName("iexplore");
			} else {
				System.out.println("Please give valid browser option");
				throw new InputMismatchException();
			}
			driver = new RemoteWebDriver(new URL(hubURL), cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get(Config.getValue("url"));
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
		
	}
}
