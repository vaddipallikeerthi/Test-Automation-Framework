package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	

	// Constructor when driver is already created
	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver);
	}
	
	/*public webDriver getDriver()
	{
		return driver.get();
	}*/

	// Constructor when browser name string is passed
	public BrowserUtility(String browserName) {
		logger.info("Launching Browser: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Invalid browser name. Use Chrome or Edge only!");
		}
	}

	// Constructor when using enum Browser
	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Invalid browser name. Use Chrome or Edge only!");
		}
	}

	// ✅ Common explicit wait (10 seconds)
	private WebElement waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Navigation
	public void goToWebSite(String url) {
		logger.info("Visiting website: " + url);
		driver.get().get(url);
	}

	public void maximizeBrowserWindow() {
		logger.info("Maximizing browser window");
		driver.get().manage().window().maximize();
	}

	// ✅ Wrapped interactions with wait
	public void clickOn(By locator) {
		logger.info("Clicking on: " + locator);
		waitForElement(locator).click();
	}

	public void enterText(By locator, String text) {
		logger.info("Entering text into: " + locator + " -> " + text);
		WebElement element = waitForElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public String getVisibleText(By locator) {
		logger.info("Getting visible text from: " + locator);
		return waitForElement(locator).getText();
	}

	// Driver getter/setter
	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}
	
	public String takeScreenshot(String name)
	{
		TakesScreenshot screenshot=(TakesScreenshot) driver.get();
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=format.format(date);
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//screenshots//"+name+"-"+timeStamp+".png";
		File screenshotFile= new File(path);
		try {
			FileUtils.copyFile(screenshotData,screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			
			if(isHeadless) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=new"); 
			//launch your browser in headless
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));}
			else
			{
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if(isHeadless)
			{
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless=old"); 
				//launch your browser in headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
				
			}
			else {
			driver.set(new EdgeDriver());}
		} else {
			throw new IllegalArgumentException("Invalid browser name. Use Chrome or Edge only!");
		}
	}
	
	
	
	
}