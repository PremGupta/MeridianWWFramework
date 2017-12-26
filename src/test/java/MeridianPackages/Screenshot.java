package MeridianPackages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot extends Announcements {
	public static String Randomscreenshotname;

	public static void getscreenshot(WebDriver driver) throws IOException {
		File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotname = "Test123";
		String filetype = ".png";
		//int randomnumber= (int) (100 + Math.random() * ((10000 - 1) + 1));
		String Randomscreenshotname = screenshotname + randomnumber + filetype;

		System.out.println("Randome image name");
		System.out.println(Randomscreenshotname);

		FileUtils.copyFile(snapshot, new File("C:\\Users\\Prem\\Meridian\\Screenshot\\" + Randomscreenshotname));
		System.out.println("screenshot taken");
	}

	public static void failedStepsScreenshot(WebDriver driver) throws IOException {
		//int randomnumber= (int) (100 + Math.random() * ((10000 - 1) + 1));
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"C:\\Users\\Prem\\Meridian\\FailedStepsScreenshots\\" + "Failed" + Randomscreenshotname));
	}
}
