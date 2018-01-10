package com.meridian.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.objectrepository.util.LoginPage;
import com.objectrepository.util.LogoutPage;
import com.resources.util.ReportLogs;
import com.resources.util.TestCaseBase;

public class Login  extends TestCaseBase{

	@Test()
	public void LoginFlow() throws IOException, InterruptedException {

		System.out.println("LoginFlow: Started");
		LoginPage loginPage = new LoginPage(this.driver);
		LogoutPage logoutPage = new LogoutPage(this.driver);

		try {
			loginPage.Login();
			loginPage.VerifyLandedOnHomePage();
			logoutPage.ClickLogoutButton();
			System.out.println("LoginFlow: Passed");
			ReportLogs.Pass(this.getClass().getName(), "LoginFlow", "Login succeeded", this.driver);
		} catch (Exception e) {
			System.out.println("LoginFlow: Failed");
			ReportLogs.Fail(this.getClass().getName(), "LoginFlow", e, this.driver);
		}
	}
}
