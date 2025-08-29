package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]/span");

	public String getUserName() {
		return getVisibleText(USERNAME_LOCATOR);
	}

}
