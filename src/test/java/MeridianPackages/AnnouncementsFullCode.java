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
import org.sikuli.script.Pattern;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Screen;

import ObjectRepository_Accessories.Shoppingcart;
import ObjectRepository_Announcements.AnnouncementsPage;
import ObjectRepository_Announcements.AwardsCentralHomePage;
import ObjectRepository_Announcements.HomePage;
import ObjectRepository_Announcements.loginPage;
import Resources.base;
import ObjectRepository_Accessories.Blenders;
import ObjectRepository_Accessories.CoffeeBevarages;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class AnnouncementsFullCode{
 
	public static WebDriver driver;
	public static int randomnumber;
	
	@Test()
	
	public void AnnouncementCreation() throws IOException, InterruptedException
	{ 
     
		try 
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prem\\Downloads\\Study\\Selenium Files\\Zip Files\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://demosite.meridinet.com/template/login.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("Meridian");
		driver.findElement(By.id("password")).sendKeys("Demo");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		WebElement admin=driver.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Admin']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(admin).build().perform();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'][text()='Admin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Announcements'])[2]")).click();
	
		driver.findElement(By.xpath("//input[@value='Create New Announcement']")).click();
		randomnumber= (int) (10 + Math.random() * ((10000 - 1) + 1));
		driver.findElement(By.xpath("//*[@id='sTitle']")).sendKeys("Test123"+randomnumber);
		driver.findElement(By.id("dFromDate")).click();
		driver.findElement(By.xpath("//*[starts-with(@class,'datepicker')]/div[1][@class='datepicker-days']/table/tbody/tr[5]/td[6]")).click();
		driver.findElement(By.id("dThruDate")).click();
		driver.findElement(By.xpath("//*[starts-with(@class,'datepicker')]/div[1][@class='datepicker-days']/table/tbody/tr[5]/td[7]")).click();
	    driver.findElement(By.xpath("//input[@id='myCheckBox']")).click();
		
		Thread.sleep(10000);
		WebElement iframeElement = driver.findElement(By.xpath(".//*[@id='cke_ckeditor']/div/div/iframe"));
	    driver.switchTo().frame(iframeElement);
	    
	    org.sikuli.script.Screen scr=new org.sikuli.script.Screen();
	    Pattern Image1=new Pattern("C:\\Users\\Prem\\Meridian\\Images\\Image1.PNG");
		scr.click(Image1);
	    scr.type("test");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Thread.sleep(5000);
		Screenshot.getscreenshot(driver);
		assertEquals(driver.findElement(By.xpath("//*[@id=\'announcement\']/div/div/div[1]/ul/li[1]/span")).getText(), "Test123"+randomnumber);
	    System.out.println("Test123"+randomnumber);
	}
	
	catch (Exception e) {
		Screenshot.failedStepsScreenshot(driver);
        e.printStackTrace();
     
	}

}


@AfterTest
public void teardown()
{
	
	driver.close();
	driver=null;
	
}

}
