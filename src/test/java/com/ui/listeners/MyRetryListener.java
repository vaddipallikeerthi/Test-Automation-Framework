package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryListener implements IRetryAnalyzer {
	private static final int MAX_CONSTANTS=3;
	private static int currentAttempt=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(currentAttempt<=MAX_CONSTANTS)
		{
			currentAttempt++;
			return true;
		}
		return false;
	}

}
