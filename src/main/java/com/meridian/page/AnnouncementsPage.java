package com.meridian.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnnouncementsPage {

	public WebDriver driver;

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
	By future = By.xpath("//a[text()='Future']");
	By showResult = By.xpath("//select[@name='table_length']");
	// By search=By.xpath("//*[@id='table_filter']/label/input");
	By annList = By.xpath("//*[@id='table_wrapper']//table/tbody/tr");

	public AnnouncementsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement createNewAnnouncement() {
		return driver.findElement(createNewAnnouncement);
	}

	public WebElement announcementTitle() {
		return driver.findElement(announcementTitle);
	}

	public WebElement fromDate() {
		return driver.findElement(fromDate);
	}

	public WebElement thruDate() {
		return driver.findElement(thruDate);
	}

	public WebElement startDate() {
		return driver.findElement(startDate);
	}

	public WebElement endDate() {
		return driver.findElement(endDate);
	}

	public WebElement clickCheckbox() {
		return driver.findElement(selectCheckbox);
	}

	public WebElement iFrame() {
		return driver.findElement(iFrame);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public WebElement approved() {
		return driver.findElement(approved);
	}

	public WebElement future() {
		return driver.findElement(future);
	}

	public WebElement annList() {
		return driver.findElement(annList);
	}

	public WebElement showResult() {
		return driver.findElement(showResult);
	}

	public void clickCreateNewAnnouncement() {
		createNewAnnouncement().click();
	}

	public void enterAnnouncementTitle(String title) {
		announcementTitle().sendKeys(title);
	}

	public void clickFromDate() {
		fromDate().click();
	}

	public void selectStartDate() {
		startDate().click();
	}

	public void clickThruDate() {
		thruDate().click();
	}

	public void selectEndDate() {
		endDate().click();
	}

	public void selectCheckbox() {
		clickCheckbox().click();
	}

	public void waitForFrameToAppear() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(iFrame));
	}

	public void enterTextIniFrameTextField() {
		driver.switchTo().frame(iFrame());
		driver.findElement(By.xpath("html/body/p")).click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("html/body/p"))).build().perform();
		act1.doubleClick(driver.findElement(By.xpath("html/body/p"))).sendKeys("shhdshaas").build().perform();
		driver.switchTo().defaultContent();
	}

	public void clickSubmitButton() {
		submit().click();
	}

	public void waitForApprovalToAppear() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(approved));
	}

	public void clickApprovalButton() {
		WebElement approved = approved();
		Actions act1 = new Actions(driver);
		act1.moveToElement(approved).build().perform();
		act1.moveToElement(approved).click().build().perform();
	}

	public void clickFuture() {
		future().click();
	}

	public void showResultSelection() {
		WebElement show = showResult();
		show.click();
		Select sel = new Select(show);
		sel.selectByVisibleText("100");
	}
	public void createAnnouncement(String announcementName) throws IOException, InterruptedException {
		clickCreateNewAnnouncement();
		enterAnnouncementTitle(announcementName);
		clickFromDate();
		selectStartDate();
		clickThruDate();
		selectEndDate();
		selectCheckbox();
		waitForFrameToAppear();
		enterTextIniFrameTextField();
		clickSubmitButton();
		waitForApprovalToAppear();
		clickApprovalButton();
		clickFuture();
		showResultSelection();
	}

}
