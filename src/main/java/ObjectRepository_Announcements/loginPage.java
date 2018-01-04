package ObjectRepository_Announcements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public static WebDriver driver;

	By username = By.id("username");
	String uname="meridian";

	By password = By.id("password");
	String pass="Demo@09123";
	
	By loginButton = By.xpath("//input[@value='Login']");

	public loginPage(WebDriver driver) {
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
	
	
	

	public void EnterUname() {
		 Username().sendKeys(uname);
	}
	
	public void EnterPassword() {
		 Password().sendKeys(pass);
	}
	
	public void ClickLoginButton() {
		 LoginButton().click();
	}
}
