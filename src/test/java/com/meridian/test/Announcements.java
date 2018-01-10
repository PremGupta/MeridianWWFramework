package com.meridian.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.objectrepository.util.AnnouncementsPage;
import com.objectrepository.util.HomePage;
import com.objectrepository.util.LoginPage;
import com.objectrepository.util.LogoutPage;
import com.resources.util.ReportLogs;
import com.resources.util.TestCaseBase;

public class Announcements extends TestCaseBase{

/*	@Test(enabled=false,priority=2)
	public void LoginFlow() throws IOException, InterruptedException {
	
		System.out.println("LoginFlow: Started");
		LoginPage loginPage = new LoginPage(this.driver);
		LogoutPage logoutPage = new LogoutPage(this.driver);
		
		try {
			loginPage.Login();
			loginPage.VerifyLandedOnHomePage();
			logoutPage.ClickLogoutButton();
			System.out.println("LoginFlow: Passed");
			ReportLogs.Pass(this.getClass().getName(),"LoginFlow", "Login succeeded", this.driver);
		}
		catch (Exception e) {
			System.out.println("LoginFlow: Failed");
			ReportLogs.Fail(this.getClass().getName(),"LoginFlow",e, this.driver);
		}
	}*/

	@Test()
	public void AnnouncementCreation() throws IOException, InterruptedException {
		System.out.println("AnnouncementCreation: Started");
		LoginPage loginPage = new LoginPage(this.driver);
		HomePage homePage = new HomePage(this.driver);
		AnnouncementsPage annPage = new AnnouncementsPage(driver);
		LogoutPage logoutPage = new LogoutPage(this.driver);
		
		try {		
			
			int randomnumber = (int) (10 + Math.random() * ((10000 - 1) + 1));
			String announcementName =  "Test123" + randomnumber;
			System.out.println(announcementName);
			
			loginPage.Login();			
			homePage.AnnouncementCreation();
			annPage.CreateAnnouncement(announcementName);			
		   // annPage.VerifyAnnouncement(announcementName);
			logoutPage.ClickLogoutButton();
			System.out.println("AnnouncementCreation: Passed");
			ReportLogs.Pass(this.getClass().getName(),"AnnouncementCreation", "Announcement Created", this.driver);
		}
		catch (Exception e) {
			System.out.println("AnnouncementCreation: Failed");
			ReportLogs.Fail(this.getClass().getName(),"AnnouncementCreation",e, this.driver);
		}
	}
}