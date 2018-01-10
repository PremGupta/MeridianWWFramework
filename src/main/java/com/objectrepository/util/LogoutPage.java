package com.objectrepository.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resources.util.base;
 
public class LogoutPage extends base {
	public Properties prop;

	By logout = By.xpath("//a[text()='Logout']");
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement LogoutButton() {
		return driver.findElement(logout);
	}

	public void ClickLogoutButton() {
		LogoutButton().click();
	}

	public void Logout() {
		ClickLogoutButton();
	}
}
