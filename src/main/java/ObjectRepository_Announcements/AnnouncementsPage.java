package ObjectRepository_Announcements;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MeridianPackages.Screenshot;

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
	public static int randomnumber = (int) (10 + Math.random() * ((10000 - 1) + 1));

	public AnnouncementsPage(WebDriver driver) {
		this.driver = driver;
	}

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

	public void ClickCreateNewAnnouncement() {
		CreateNewAnnouncement().click();
	}

	public void EnterAnnouncementTitle() {
		AnnouncementTitle().sendKeys("Test123" + randomnumber);
	}

	public void ClickFromDate() {
		FromDate().click();
	}

	public void SelectStartDate() {
		StartDate().click();
	}

	public void ClickThruDate() {
		ThruDate().click();
	}

	public void SelectEndDate() {
		EndDate().click();
	}

	public void SelectCheckbox() {
		ClickCheckbox().click();
	}

	public void WaitForFrameToAppear() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(iFrame));
	}

	public void EnterTextIniFrameTextField() {
		driver.switchTo().frame(IFrame());
		driver.findElement(By.xpath("html/body/p")).click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("html/body/p"))).build().perform();
		act1.doubleClick(driver.findElement(By.xpath("html/body/p"))).sendKeys("shhdshaas").build().perform();
		driver.switchTo().defaultContent();
	}

	public void ClickSubmitButton() {
		Submit().click();
	}

	public void WaitForApprovalToAppear() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(approved));
	}

	public void VerifyAnnouncementCreated() throws IOException {
		assertEquals(driver.findElement(By.xpath("//*[@id=\'announcement\']/div/div/div[1]/ul/li[1]/span")).getText(),
				"Test123" + randomnumber);
		System.out.println("Test123" + randomnumber);
		Screenshot.getscreenshot(driver, randomnumber);
	}

	public void ClickApprovalButton() {
		WebElement Approved = Approved();
		Actions act1 = new Actions(driver);
		act1.moveToElement(Approved).build().perform();
		act1.moveToElement(Approved).click();
	}

	public void CreateAnnouncement() throws IOException {
		ClickCreateNewAnnouncement();
		EnterAnnouncementTitle();
		ClickFromDate();
		SelectStartDate();
		ClickThruDate();
		SelectEndDate();
		SelectCheckbox();
		WaitForFrameToAppear();
		EnterTextIniFrameTextField();
		ClickSubmitButton();
		WaitForApprovalToAppear();
		VerifyAnnouncementCreated();
		ClickApprovalButton();
	}
}
