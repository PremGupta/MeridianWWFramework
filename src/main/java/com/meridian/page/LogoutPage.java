package com.meridian.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class LogoutPage {
 	
	By logout = By.xpath("//a[text()='Logout']");
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement logoutButton() {
		return driver.findElement(logout);
	}

	public void logout() {
		logoutButton().click();
	}
}
