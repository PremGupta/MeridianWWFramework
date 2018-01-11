package com.meridian.page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.meridian.util.Config;

public class LoginPage {
 
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//input[@value='Login']");
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		 this.driver = driver;
	}

	public WebElement username() {
		return driver.findElement(username);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}

	public void enterUname() throws IOException {
		String username = Config.getValue("uname");
		username().sendKeys(username);
	}

	public void enterPassword() throws IOException {
		String password = Config.getValue("pass");
		password().sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton().click();
	}

	public boolean login() {
		try {
			enterUname();
			enterPassword();
			clickLoginButton();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void verifyLandedOnHomePage() {
		assertEquals(driver.findElement(By.xpath("//h1[text()='Welcome']")).getText(), "Welcome");
	}
}
