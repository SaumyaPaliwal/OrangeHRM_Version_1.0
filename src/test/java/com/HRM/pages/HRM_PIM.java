package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HRM_PIM 

{
	WebDriver driver;

	@FindBy(how = How.XPATH,using="//input[@id='firstName']")
	WebElement firstName;

	@FindBy(xpath="//input[@id='middleName']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='employeeId']")
	WebElement empID;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	WebElement loginDetails;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@id='user_name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@id='re_password']")
	WebElement confirmPassword;

	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement pimOption;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	WebElement addEmployee;
	
	

	public HRM_PIM(WebDriver d) 
	{
		driver = d;
		PageFactory.initElements(driver,this);
	}

	

	public void setFirstName(String firstNameValue)
	{
		try {
			firstName.sendKeys(firstNameValue);
		} catch (Exception e) {
			System.out.println("Unable to set the value " +e);
		}
		
	}

	public void setMiddleName(String middleNameValue)
	{
		middleName.sendKeys(middleNameValue);
	}
	
	public void setLastName(String lastNameValue)
	{
		lastName.sendKeys(lastNameValue);
	}
	
	public void setEmployeID(String empIDValue)
	{
		empID.sendKeys(empIDValue);
	}
	
	public void setUsername(String userNameValue)
	{
		userName.sendKeys(userNameValue);
	}
	
	public void setPassword(String passWordValue)
	{
		passWord.sendKeys(passWordValue);
	}
	
	public void setConfirmPassword(String confirmPasswordValue)
	{
		confirmPassword.sendKeys(confirmPasswordValue);
	}

	public void clickOnPIMTab()
	{
		try {
			pimOption.click();
		} catch (Exception e) {
			System.out.println("Unable to click on the value " +e);
		}	
	}
	
	public void clickOnAddEmployee()
	{
		addEmployee.click();
	}
	
	public void clickOnLoginDetails()
	{
		loginDetails.click();
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
