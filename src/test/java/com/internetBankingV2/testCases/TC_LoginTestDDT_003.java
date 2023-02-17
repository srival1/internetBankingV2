package com.internetBankingV2.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.internetBankingV2.pageObjects.*;
import com.internetBankingV2.utilities.ExcelUtilities;



import java.io.IOException;
//import java.util.ArrayList;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

public class TC_LoginTestDDT_003 extends BaseClass2 {
	
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/internetBankingV2/testData/LoginData.xlsx";
		
		int rownum = ExcelUtilities.getRowCount(path,"Sheet1");
		int colcount = ExcelUtilities.getCellCount(path,"Sheet1",1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for (int i=1;i <= rownum; i++)
		{
			for(int j=0;j < colcount; j++)
			{
				logindata[i-1][j] = ExcelUtilities.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
	//User Defined Method Created to check alert is Present or Not on UI
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e){
		return false;
		}
	
	}
	
	@Test(dataProvider = "LoginData")
	public void loginTestDDT(String uname, String pwd) throws IOException, InterruptedException
	{
		
		driver.get(baseUrl);
		logger.info("Site is Opened");
		LoginPage lp = new LoginPage(driver);
		
		lp.clickReset();
		logger.info("Fields are Reset");
		
		lp.setUserName(uname);
		logger.info("UserName is Keyed in");
		
		lp.setPassword(pwd);
		logger.info("Password is Keyed in");
		
		lp.clickLogin();
		logger.info("Login Button is Pressed");
		Thread.sleep(3000);
		
		
		
		if(isAlertPresent() == true)
		{
			logger.info("Login Failed for UserName:"+uname);
			captureScreen(driver,"loginTestDDT");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Invalid User Alert Accepted");
			Assert.assertTrue(false);
		}
		else {
			lp.clickLogout();
			Thread.sleep(3000);
			logger.info("Logout Button is Pressed");
			driver.switchTo().alert().accept();
			logger.info("Logout Alert Accepted");
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		
		/*if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else {
			captureScreen(driver, "loginTestDDT");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}*/
		
	}

}
