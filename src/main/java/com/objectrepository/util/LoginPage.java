package com.objectrepository.util;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resources.util.Config;
import com.resources.util.base;

public class LoginPage extends base {
	// public Properties prop;

	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//input[@value='Login']");
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		 this.driver = driver;
	}

	public WebElement Username() {
		return driver.findElement(username);

	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement LoginButton() {
		return driver.findElement(loginButton);
	}

	public void EnterUname() throws IOException {
		String username = Config.getValue("uname");
		Username().sendKeys(username);
	}

	public void EnterPassword() throws IOException {
		String Password = Config.getValue("pass");
		Password().sendKeys(Password);
	}

	public void ClickLoginButton() {
		LoginButton().click();
	}

	public void Login() throws IOException {
		EnterUname();
		EnterPassword();
		ClickLoginButton();
	}

	public void VerifyLandedOnHomePage() {
		assertEquals(driver.findElement(By.xpath("//h1[text()='Welcome']")).getText(), "Welcome");
	}
}
