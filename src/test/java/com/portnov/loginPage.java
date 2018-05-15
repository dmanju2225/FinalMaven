package com.portnov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
private static WebDriver driver;
//page elements
@FindBy(id="username")
private WebElement username;

@FindBy(id="password")
private WebElement password;

@FindBy(className="radius")
private WebElement loginbutton;

@FindBy(id="flash")
private WebElement logoutMessage;

//constructor
public loginPage(WebDriver aDriver)
{
	driver=aDriver;
}

//page services
public void enterusername(String user)
{
	username.sendKeys(user);
}

public void enterPassword(String pass)
{
	password.sendKeys(pass);
}

public void clickLoginButton()
{
	loginbutton.click();
}
public void submitLogin(String user, String pass)
{
	enterusername(user);
	enterPassword(pass);
	clickLoginButton();
}

public static loginPage open(WebDriver aDriver, String url)
{
	aDriver.get(url);
	return PageFactory.initElements(aDriver, loginPage.class);//creating loginPage object
}

public SecureAreaPage validLogin(String user, String pass)
{
	submitLogin(user,pass);
	return PageFactory.initElements(driver, SecureAreaPage.class);//creating SecureAreaPage object;
}

public String getLogoutMessage()
{
	return logoutMessage.getText();
	
}
}
