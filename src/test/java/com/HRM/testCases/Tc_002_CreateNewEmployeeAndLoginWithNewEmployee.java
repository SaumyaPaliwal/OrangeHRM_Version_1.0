package com.HRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.pages.HRM_HomePage;
import com.HRM.pages.HRM_LoginPage;
import com.HRM.pages.HRM_PIM;
import com.HRM.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

public class Tc_002_CreateNewEmployeeAndLoginWithNewEmployee extends BaseClass

{
	HRM_PIM pim;
	HRM_LoginPage lp;
	HRM_HomePage hp;

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
  public void creatingNewUser()  throws Exception
  {
	  
	  String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
	  setLogger(currenMethodName);
	  
	  pim = new HRM_PIM(driver);
	  
	  pim.clickOnPIMTab();
	  log.info("User Clicked on PIM Tab"); //log4j
	  customLogger(Status.PASS, "User Clicked on PIM Tab", ExtentColor.GREEN); //extentReport logs
	  pim.clickOnAddEmployee();
	  log.info("User Clicked on Add Employee"); //log4j
	  customLogger(Status.PASS, "User Clicked on Add Employee", ExtentColor.GREEN); //extentReport logs
	  pim.setFirstName("DEMO");
	  log.info("FirstName is set");
	  customLogger(Status.PASS, "FirstName is set successfully", ExtentColor.GREEN);
	  pim.setMiddleName("QA");
	  log.info("MiddleName is set");
	  customLogger(Status.PASS, "MiddleName is set successfully", ExtentColor.GREEN);
	  pim.setLastName("TEST06");
	  log.info("LastName is set");
	  customLogger(Status.PASS, "LastName is set successfully", ExtentColor.GREEN);
	  pim.setEmployeID("0392");
	  log.info("EmployeeID is set");
	  customLogger(Status.PASS, "EmployeeID is set successfully", ExtentColor.GREEN);
	  pim.clickOnLoginDetails();
	  log.info("User Clicked on LoginDetails Checkbox"); //log4j
	  customLogger(Status.PASS, "User Clicked on LoginDetails Checkbox", ExtentColor.GREEN); //extentReport logs
	  pim.setUsername("DEMOTEST06");
	  log.info("Username is set");
	  customLogger(Status.PASS, "Username is set successfully", ExtentColor.GREEN);
	  pim.setPassword("Test1234");
	  log.info("Password is set");
	  customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
	  pim.setConfirmPassword("Test1234");
	  log.info("ConfirmPassword is set");
	  customLogger(Status.PASS, "ConfirmPassword is set successfully", ExtentColor.GREEN);
	  pim.clickOnSaveButton();
	  Thread.sleep(3000);
	  log.info("User Clicked on saveButton"); //log4j
	  customLogger(Status.PASS, "User Clicked on SaveButton", ExtentColor.GREEN); //extentReport logs	   
  }
  
  @Test(priority=4)
  public void logOutFromHRMApplication()  throws Exception
  {
	  String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
	  setLogger(currenMethodName);
	  hp = new HRM_HomePage(driver);
	  hp.clickOnWelcomeOption();
	  Thread.sleep(5000);
	  hp.clickOnLogOutButton();
	  log.info("Clicked on the logout button");
	 customLogger(Status.INFO, "User Clicked on the Logout button", ExtentColor.WHITE);
  }
  
  @Test(priority=5)
  public void loginWithNewlyCreatedUser()  
  {
	  	String currenMethodName = new Exception().getStackTrace()[0].getMethodName();
		lp = new HRM_LoginPage(driver);
		setLogger(currenMethodName);
			
		lp.setUserName("DEMOTEST06");
		log.info("Username is set");
		customLogger(Status.PASS, "Username is set successfully", ExtentColor.GREEN);
		lp.setPassWord("Test1234");
		customLogger(Status.PASS, "Password is set successfully", ExtentColor.GREEN);
		log.info("Password is set");	
		lp.clickOnLoginButton();
		log.info("Clicked on the login button");
		customLogger(Status.INFO, "User Clicked on the login button", ExtentColor.WHITE);

		String expectedTitle = "OrangeHRM";
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
