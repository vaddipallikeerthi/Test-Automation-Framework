package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	
	@BeforeMethod(description = "Load the home page of the website")
	public void setUp(
		     @Optional("chrome") String browser,
		    @Optional("false") boolean isLambdaTest,
		    @Optional("true") boolean isHeadless,
		    ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage=new HomePage(lambdaDriver);
		}
		else {
		logger.info("Load the homepage of the website");
		homePage = new HomePage(Browser.CHROME,true);}
	}
	
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else {
		homePage.quit();}
	}


}
