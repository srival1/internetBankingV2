package com.internetBankingV2.testCases;

import org.testng.annotations.Test;
import com.internetBankingV2.pageObjects.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

public class TC_AddCustomer_004 extends BaseClass1 {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		try
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
			
			//Thread.sleep(3000);
			
			AddCustomerPage addcust = new AddCustomerPage(driver);
			
			addcust.clickAddNewCustomer();
			Thread.sleep(2000);
			
			addcust.custName("Tester");
			addcust.custgender("male");
			addcust.custdob("12","15","1990");
			addcust.custaddress("INDIA");
			addcust.custcity("Hyderabad");
			addcust.custstate("Telangana");
			addcust.custpinno("5000072");
			addcust.custtelephoneno("9848022335");
			
			String email=randomestring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custsubmit();
			
			String txtbody = driver.findElement(By.xpath("/html/body")).getText();		
			
			if (txtbody.contains("Connection failed: Access denied for user 'root'@'localhost' (using password: NO)"))
			{
				Assert.assertTrue(true);
				logger.info("Add Customer Test Passed");
			}
			else 
			{
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
				logger.info("Add Customer Test Failed");
			}
			
		}
		
	 catch (InterruptedException | IOException e) 
		{
		e.printStackTrace();
		}

}
}
