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

	@Test(dependsOnMethods = { "LoginFlow" })
	public void AnnouncementCreation() throws IOException, InterruptedException {

		try {
			loginPage.Login();
			loginPage.VerifyLandedOnHomePage();
			homePage.AnnouncementCreation();
			annPage.CreateAnnouncement();
			logoutPage.ClickLogoutButton();
			LogForPass(this.getClass().getName());
		}
		catch (Exception e) {
			LogForFail(e);
		}

	}

}