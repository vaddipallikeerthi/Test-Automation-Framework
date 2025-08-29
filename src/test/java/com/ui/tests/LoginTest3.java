package com.ui.tests;

import com.constants.Browser;
import com.pages.HomePage;
import com.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest3 extends TestBase {
	//HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	@Test(description = "Verifies if the valid user is able to login", groups = { "Sanity",
			"Regression" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginJsonTest(User user) {

		// MyAccountPage
		Assert.assertEquals(
				homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Chintu v");

	}

	/*@Test(description = "Verifies if the valid user is able to login", groups = { "Sanity",
			"Regression" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelReader")
	public void loginExcelTest(User user) {

		Assert.assertEquals(homePage.goToLoginPage().doLoginWith("vosali3505@jobzyy.com", "password"), "Chintu v");

	}

	@Test(description = "Verifies if the valid user is able to login", groups = { "Sanity",
			"Regression" }, retryAnalyzer = com.ui.listeners.MyRetryListener.class)
	public void loginTest() {

		MyAccountPage accountPage = homePage.goToLoginPage().doLoginWith("vosali3505@jobzyy.com", "password");
		String actualUserName = accountPage.getUserName();

		Assert.assertEquals(actualUserName, "Chintu v");

	}*/

}
