package com.HRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 

{
	Properties po;
	
	public ReadConfig() 
	{
		File src = new File(".\\Configurations\\config.properties");		
		try {
			FileInputStream fi = new FileInputStream(src);
			po = new Properties();
			po.load(fi);
			
		} catch (Exception e) 
		{
			System.out.println("Unable to load file: "+e);
		}
	}
	
	
	public String getApplicationURL()
	{
		String value = po.getProperty("HRM_url");
		return value;
	}
	
	public String getUserName()
	{
		String value = po.getProperty("userName");
		return value;
	}
	
	public String getPassWord()
	{
		String value = po.getProperty("passWord");
		return value;
	}
	
	public String getChromeDriverPath()
	{
		String value = po.getProperty("chrome");
		return value;
	}
	
	public String getFireFoxDriverPath()
	{
		String value = po.getProperty("fireFox");
		return value;
	}
	
	

}
