package com.internetBankingV2.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.internetBankingV2.utilities.ReadConfig;


public class BaseClass2 {
	
	ReadConfig readconf = new ReadConfig();
	
	public String baseUrl = readconf.getBaseURL();
	public String username = readconf.getUserName();
	public String password = readconf.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("NetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		switch (br) {
		  case "chrome":
			  System.setProperty("webdriver.chrome.driver",readconf.getChromePath());//System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			  driver = new ChromeDriver();

		    break;
		    
		  case "firefox":
			  System.setProperty("webdriver.gecko.driver",readconf.getFirefoxPath());
			  driver= new FirefoxDriver();
			  //driver.manage().window().maximize();
			  
		    break;
		    
		  case "edge":
			  System.setProperty("webdriver.edge.driver",readconf.getEdgePath());
			  driver = new EdgeDriver();
			    break;
		  case "ie":
			  System.setProperty("webdriver.ie.driver",readconf.getIEPath());
			  driver = new InternetExplorerDriver();
			    break;
		  default:
			  System.setProperty("webdriver.chrome.driver",readconf.getChromePath());//System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			  driver = new ChromeDriver();
		}
		
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
