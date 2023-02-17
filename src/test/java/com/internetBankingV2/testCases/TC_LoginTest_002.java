package com.internetBankingV2.testCases;

import org.testng.annotations.Test;
import com.internetBankingV2.pageObjects.*;

import java.io.IOException;

import org.testng.Assert;

public class TC_LoginTest_002 extends BaseClass2 {
	
	@Test
	public void loginTest2() throws IOException
	{
		driver.get(baseUrl);
		logger.info("Site is Opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.clickReset();
		logger.info("Fields are Reset");
		
		lp.setUserName(username);
		logger.info("UserName is Keyed in");
		
		lp.setPassword(password);
		logger.info("Password is Keyed in");
		
		lp.clickLogin();
		logger.info("Login Button is Pressed");
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else {
			captureScreen(driver, "loginTest2");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
