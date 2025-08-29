package com.ui.tests;

import com.constants.Browser;
import com.pages.HomePage;
import com.ui.pojo.User;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	HomePage homePage;

	@BeforeMethod(description = "Load the home page of the website")
	public void setUp() {
		homePage = new HomePage(Browser.CHROME);
	}

	@Test(description = "Verifies if the valid user is able to login", groups = { "Sanity",
			"Regression" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void login(User user) {

		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUserName();
		Assert.assertEquals(userName, "Chintu v");

	}

}
