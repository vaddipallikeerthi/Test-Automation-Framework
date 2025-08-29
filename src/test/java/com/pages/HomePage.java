package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Environment;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility { /// PAGE OBJECT DESIGN PATTERN
	
	Logger logger=LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser chrome, boolean b) {
		super(chrome,true);
		goToWebSite(PropertiesUtil.readProperty(Environment.QA,"URL"));
		// TODO Auto-generated constructor stub
	}

	private static final By SIGNIN_LINK_LOCATOR = By.xpath("//a[@class='login']");

	public LoginPage goToLoginPage()// page functions---->
	{
		logger.info("Trying to do login");
		clickOn(SIGNIN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(PropertiesUtil.readProperty(Environment.QA,"URL"));
		// TODO Auto-generated constructor stub
	}

	public void quit() {
		// TODO Auto-generated method stub
		
		
	}
	
	
	

}
