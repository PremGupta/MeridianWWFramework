package com.resources.util;

import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	//public static Properties prop;

	public Browser() {
	}

	public static WebDriver GetDriver() {
		WebDriver driver = null;
		String browserName = Config.getValue("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			String path = Config.getValue("chrome");
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else if (browserName.equals("firefox")) {
			String path = Config.getValue("firefox");
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browserName.equals("IE")) {
			String path = Config.getValue("IE");
			System.setProperty("webdriver.ie.driver", path);
			driver = new InternetExplorerDriver();
			driver.get(Config.getValue("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		if (driver != null)
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
