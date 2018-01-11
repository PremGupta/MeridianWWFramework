package com.meridian.test;

import java.io.IOException;

import org.testng.annotations.Test;

public class Announcements extends TestCaseBase {

	@Test(enabled = true, priority = 0)
	public void LoginFlow() throws IOException, InterruptedException {

		loginPage.login();
		loginPage.verifyLandedOnHomePage();
		logoutPage.logout();

	}

	@Test(enabled = true, priority = 1)
	public void AnnouncementCreation() throws IOException, InterruptedException {

		int randomnumber = (int) (10 + Math.random() * ((10000 - 1) + 1));
		String announcementName = "Test123" + randomnumber;

		loginPage.login();
		homePage.clickAnnouncement();
		annPage.createAnnouncement(announcementName);
		logoutPage.logout();
	}
}