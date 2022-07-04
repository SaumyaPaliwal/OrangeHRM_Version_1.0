package com.HRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.HRM.pages.HRM_LoginPage;
import com.HRM.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;


public class Tc_001_LoginIntoAppWithValidCreds extends BaseClass
{
	HRM_LoginPage lp;
	
	@Test(priority=1)
	public void set_LoginCredentials()
	{
		
		String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		lp = new HRM_LoginPage(driver);
		setLogger(currenMethodName);
			
		lp.setUserName(userName);
		log.info("Username is set");
		customLogger(Status.PASS, "Username is set successfully", ExtentColor.GREEN);
		lp.setPassWord(passWord);
		customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
		log.info("Password is set");	
	}
	
	@Test(priority=2)
	public void click_onLoginButton()
	{
		String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		setLogger(currenMethodName);
		lp.clickOnLoginButton();
		log.info("Clicked on the login button");
		
		customLogger(Status.INFO, "User Clicked on the login button", ExtentColor.WHITE);
	}
	
	@Test(priority=3)
	public void verifyTheTitle_AfterLogin()
	{
		String expectedTitle = "OrangeHRM";
		String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		setLogger(currenMethodName);
		if (driver.getTitle().equals(expectedTitle)) 
		{		
			log.info("Actual Title : "+driver.getTitle()+" Matched with Expected title : "+expectedTitle);
			customLogger(Status.PASS, "Actual Title : "+driver.getTitle()+" Matched with Expected title : "+expectedTitle, ExtentColor.GREEN);
			Assert.assertTrue(true, "Expected Title & Actual Title matched");
		} else 
		{
			takeScreenshot(currenMethodName, driver);
			log.info("Actual Title : "+driver.getTitle()+" did not match with Expected title : "+expectedTitle);
			customLogger(Status.FAIL,"Actual Title : "+driver.getTitle()+" did not match with Expected title : "+expectedTitle, ExtentColor.RED);
			Assert.assertTrue(false, "Expected Title & Actual Title did not match");
		}
	}
	
}
