package MeridianPackages;

import java.io.IOException;

import org.testng.annotations.Test;

import ObjectRepository_Announcements.AnnouncementsPage;
import resources.base;

public class Announcements extends base {

	@Test()
	public void LoginFlow() throws IOException, InterruptedException {

		try {

			loginPage.Login();
			loginPage.VerifyLandedOnHomePage();
			logoutPage.ClickLogoutButton();
			LogForPass(this.getClass().getName());
		}
		catch (Exception e) {
			 LogForFail(e);
		}
	}

	@Test()
	public void AnnouncementCreation() throws IOException, InterruptedException {

		try {		
			
			int randomnumber = (int) (10 + Math.random() * ((10000 - 1) + 1));
			String announcementName =  "Test123" + randomnumber;
			loginPage.Login();			
			homePage.AnnouncementCreation();
			annPage.CreateAnnouncement(announcementName);			
			//annPage.GotoAnnouncementListingPage();
			annPage.VerifyAnnouncement(announcementName);
			logoutPage.ClickLogoutButton();
			LogForPass(this.getClass().getName());
		}
		catch (Exception e) {
			LogForFail(e);
		}

	}

}