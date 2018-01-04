package ObjectRepository_Announcements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AnnouncementsPage {

	public static WebDriver driver;

	By createNewAnnouncement = By.xpath("//input[@value='Create New Announcement']");
	By announcementTitle = By.xpath("//*[@id='sTitle']");
	By fromDate = By.id("dFromDate");
	By startDate = By
			.xpath("//*[starts-with(@class,'datepicker')]/div[1][@class='datepicker-days']/table/tbody/tr[5]/td[6]");
	By thruDate = By.id("dThruDate");
	By endDate = By
			.xpath("//*[starts-with(@class,'datepicker')]/div[1][@class='datepicker-days']/table/tbody/tr[5]/td[7]");
	By announcementText = By.xpath(".//*[@id='cke_ckeditor']/div[1]/div[@id='cke_1_contents']");
	By selectCheckbox = By.xpath("//input[@id='myCheckBox']");
	By iFrame = By.xpath(".//div[@id='cke_1_contents']/iframe");
	By submit = By.xpath("//button[@id='submit']");
	By approved = By.xpath("//input[@value='Approved']");

	public AnnouncementsPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * public void Awards() {
	 * 
	 * Actions act=new Actions(driver);
	 * //act.moveToElement((WebElement)awards).build().perform();
	 * act.moveToElement((WebElement) awards).build().perform();
	 * 
	 * }
	 */

	public WebElement CreateNewAnnouncement() {
		return driver.findElement(createNewAnnouncement);
	}

	public WebElement AnnouncementTitle() {
		return driver.findElement(announcementTitle);
	}

	public WebElement FromDate() {
		return driver.findElement(fromDate);
	}

	public WebElement ThruDate() {
		return driver.findElement(thruDate);
	}

	public WebElement StartDate() {
		return driver.findElement(startDate);
	}

	public WebElement EndDate() {
		return driver.findElement(endDate);
	}

	public WebElement ClickCheckbox() {
		return driver.findElement(selectCheckbox);
	}

	public WebElement IFrame() {
		return driver.findElement(iFrame);
	}

	public WebElement Submit() {
		return driver.findElement(submit);
	}

	public WebElement Approved() {
		return driver.findElement(approved);
	}
	
	public void ClickCreateNewAnnouncement(){
		CreateNewAnnouncement().click();
	}
	
	public void EnterAnnouncementTitle(){
		int randomnumber = (int) (10 + Math.random() * ((10000 - 1) + 1));
		AnnouncementTitle().sendKeys("Test123" + randomnumber);
	}
	
	public void ClickFromDate(){
		FromDate().click();
	}
	
	public void SelectStartDate(){
		StartDate().click();
	}
	
	public void ClickThruDate(){
		ThruDate().click();
	}
	
	public void SelectEndDate(){
		EndDate().click();
	}
	
	public void SelectCheckbox(){
		ClickCheckbox().click();
	}
}
