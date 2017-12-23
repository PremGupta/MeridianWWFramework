package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage{
	
	public static WebDriver driver;

	   By awards=By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Awards']");
	   By awardscentral=By.xpath("//a[text()='Awards-Central']");
	   By admin=By.xpath("//a[@class='dropdown-toggle has-submenu'] [text()='Admin']");
	   By announcement=By.xpath("(//a[text()='Announcements'])[2]");
	   
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
/*   public void Awards()
   {
	  
	   Actions act=new Actions(driver);
	   //act.moveToElement((WebElement)awards).build().perform();
	   act.moveToElement((WebElement) awards).build().perform();
	
   }*/
	
	
	   public  WebElement AwardsCentral()
	   {
		   return driver.findElement(awardscentral);
	   }
	   
	   public  WebElement Admin()
	   {
		   return driver.findElement(admin);
	   }
	   
	   public  WebElement Announcement()
	   {
		   return driver.findElement(announcement);
	   }
   
}
