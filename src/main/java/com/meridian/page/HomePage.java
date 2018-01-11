package com.meridian.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;

	By awards = By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Awards']");
	By awardscentral = By.xpath("//a[text()='Awards-Central']");
	By admin = By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Admin']");
	By announcement = By.xpath("(//a[text()='Announcements'])[2]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement awardsCentral() {
		return driver.findElement(awardscentral);
	}

	public WebElement admin() {
		return driver.findElement(admin);
	}

	public WebElement announcement() {
		return driver.findElement(announcement);
	}
	
	public void clickAdmin() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement admin = driver
				.findElement(By.xpath("//a[@class='dropdown-toggle has-submenu'][text()='Admin']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(admin).build().perform();
		admin().click();
	}
	
	public void clickAnnouncementPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		announcement().click();
	}
	
	public void clickAnnouncement() throws InterruptedException
	{
		clickAdmin();
		clickAnnouncementPage();
	}

}
