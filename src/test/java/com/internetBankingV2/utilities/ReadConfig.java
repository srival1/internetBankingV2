package com.internetBankingV2.utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class ReadConfig
{
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		
			} 
		
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("Exception is: " + e.getMessage());
		}
		
		
	}
	
	
	public String getBaseURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}

	public String getFirefoxPath()
	{
		String fire = pro.getProperty("firefoxpath");
		return fire;
	}
	
	public String getEdgePath()
	{
		String edge = pro.getProperty("edgepath");
		return edge;
	}
	
	public String getIEPath()
	{
		String ie = pro.getProperty("iepath");
		return ie;
	}
	
}