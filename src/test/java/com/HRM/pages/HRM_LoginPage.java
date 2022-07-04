package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HRM_LoginPage 

{
	WebDriver driver;

	@FindBy(how = How.XPATH,using="//input[@id='txtUsername']")
	WebElement userName;

	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement passWord;

	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;

	public HRM_LoginPage(WebDriver d) 
	{
		driver = d;
		PageFactory.initElements(driver,this);
	}


	public void setUserName(String userNameValue)
	{
		userName.sendKeys(userNameValue);
	}

	public void setPassWord(String passWordValue)
	{
		passWord.sendKeys(passWordValue);
	}

	public void clickOnLoginButton()
	{
		loginButton.click();
	}

}
