package com.meridian.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	//public static String randomscreenshotname;

	public static void passedStepsScreenshot(WebDriver driver, String filename) throws IOException {
		File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String filetype = ".png";
		String Randomscreenshotname = filename + filetype;
		System.out.println("Randome image name");
		System.out.println(Randomscreenshotname);
		FileUtils.copyFile(snapshot, new File("./Screenshot\\" + Randomscreenshotname));
		System.out.println("Verified Created Announcement");
	}

	public static void failedStepsScreenshot(WebDriver driver, String filename) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	 	String filetype = ".png";
		String Randomscreenshotname = filename + filetype;
		System.out.println("Failed script screenshot taken");
		System.out.println(Randomscreenshotname);

		FileUtils.copyFile(src, new File("./FailedStepsScreenshots\\" + "Failed" + Randomscreenshotname));
	}
}
