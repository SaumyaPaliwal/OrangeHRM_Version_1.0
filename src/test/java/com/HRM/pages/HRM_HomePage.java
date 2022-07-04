package com.HRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HRM_HomePage 

{
	WebDriver driver;

	@FindBy(how = How.XPATH,using="//a[@id='welcome']")
	WebElement welcome;

	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOut;

	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginButton;

	public HRM_HomePage(WebDriver d) 
	{
		driver = d;
		PageFactory.initElements(driver,this);
	}

	public void clickOnWelcomeOption()
	{
		welcome.click();
	}
	
	public void clickOnLogOutButton()
	{
		logOut.click();
	}


}
