package ObjectRepository_Announcements;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class LoginPage extends base {
	public Properties prop;

	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//input[@value='Login']");

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
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./data.properties");
		prop.load(fis);
		String username = prop.getProperty("uname");
		Username().sendKeys(username);
	}

	public void EnterPassword() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"./data.properties");
		prop.load(fis);
		String Password = prop.getProperty("pass");
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
	
	public void VerifyLandedOnHomePage(){
		assertEquals(driver.findElement(By.xpath("//h1[text()='Welcome']")).getText(), "Welcome");
	}
}
