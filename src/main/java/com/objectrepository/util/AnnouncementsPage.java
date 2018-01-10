package com.objectrepository.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By future = By.xpath("//a[text()='Future']");
	By showResult = By.xpath("//select[@name='table_length']");
	// By search=By.xpath("//*[@id='table_filter']/label/input");
	By annList = By.xpath("//*[@id='table_wrapper']//table/tbody/tr");

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

	public WebElement Future() {
		return driver.findElement(future);
	}

	/*
	 * public WebElement Search() { return driver.findElement(search); }
	 */

	public WebElement AnnList() {
		return driver.findElement(annList);
	}

	public WebElement ShowResult() {
		return driver.findElement(showResult);
	}

	public void ClickCreateNewAnnouncement() {
		CreateNewAnnouncement().click();
	}

	public void EnterAnnouncementTitle(String title) {
		AnnouncementTitle().sendKeys(title);
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
		wait.until(ExpectedConditions.elementToBeClickable(approved));
	}

	public void ClickApprovalButton() {
		WebElement Approved = Approved();
		Actions act1 = new Actions(driver);
		act1.moveToElement(Approved).build().perform();
		act1.moveToElement(Approved).click().build().perform();
	}

	public void ClickFuture() {
		Future().click();
	}

	public void ShowResultSelection() {
		WebElement show = ShowResult();
		show.click();
		Select sel = new Select(show);
		sel.selectByVisibleText("100");
	}

	/*
	 * public void EnterSearchResults(String announcementName) throws
	 * InterruptedException { Thread.sleep(5000);
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); Actions
	 * act=new Actions(driver);
	 * act.moveToElement(Search()).click().build().perform();
	 * act.moveToElement(Search()).sendKeys(announcementName).build().perform(); }
	 */

	/*public void VerifyAnnouncement(String announcementName) throws IOException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> annListElements = driver.findElements(annList);
		System.out.println(annListElements.contains(announcementName));

		for (int i = 0; i < annListElements.size(); i++) {
			System.out.println(annListElements.get(i).getText());
			boolean annFound = driver
					.findElements(By.xpath("//*[@id='table_wrapper']//table/tbody/tr[" + i + "]/td[2]/b")).get(i)
					.getText().contains(announcementName);
			if (annFound == true) {
				String annFoundText = driver
						.findElements(By.xpath("//*[@id='table_wrapper']//table/tbody/tr[" + i + "]/td[2]/b")).get(i)
						.getText();
				System.out.println(annFoundText);
				assertEquals(
						driver.findElement(By.xpath("//*[@id='table_wrapper']//table/tbody/tr[i]/td[2]/b")).getText(),
						announcementName);
				System.out.println("VerifyAnnouncement is Failed");
				// Screenshot.getscreenshot(driver, announcementName);

			}
		}
	}*/

	public void CreateAnnouncement(String announcementName) throws IOException, InterruptedException {
		ClickCreateNewAnnouncement();
		EnterAnnouncementTitle(announcementName);
		ClickFromDate();
		SelectStartDate();
		ClickThruDate();
		SelectEndDate();
		SelectCheckbox();
		WaitForFrameToAppear();
		EnterTextIniFrameTextField();
		ClickSubmitButton();
		WaitForApprovalToAppear();
		ClickApprovalButton();
		ClickFuture();
		// EnterSearchResults(announcementName);
		ShowResultSelection();
	}

	public void GotoAnnouncementListingPage() {
		driver.get("abc.html");
	}

}
