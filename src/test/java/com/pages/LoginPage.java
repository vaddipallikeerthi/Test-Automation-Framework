package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MyAccountPage doLoginWith(String username, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, username);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		
		return myAccountPage;

	}

}
