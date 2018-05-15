package com.portnov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage
{
	private WebDriver driver;
	//page elements
	@FindBy(id="flash")
	private WebElement loginConfirmation;

	@FindBy(css=".icon-2x.icon-signout")
	private WebElement logoutButton;
	
	//constructor
	public SecureAreaPage(WebDriver aDriver)
	{
		driver=aDriver;
	}
	//page services
	public loginPage logout()
	{  
		logoutButton.click();
		return PageFactory.initElements(driver, loginPage.class);//creating loginPage object
	}
	
	public String getLoginMessage()
	{
		return loginConfirmation.getText();
		
	}


}
