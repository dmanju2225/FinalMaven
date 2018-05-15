package com.portnov;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinalProjectTuesday
{
	private String pageUrl="http://the-internet.herokuapp.com/login";
private WebDriver driver;
private loginPage loginPage;
	@Before
	public void setUp() throws Exception {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		loginPage=loginPage.open(driver, pageUrl);
	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}
	

	@Test
	public void test() {
		
		//SecureAreaPage secureAreaPage=loginPage.validLogin("tomsmith", "SuperSecretPassword!");
		//loginPage.validLogin("tomsmith", "SuperSecretPassword!").logout();
		//String loginConfirm=loginPage.validLogin("tomsmith", "SuperSecretPassword!").getLoginMessage();
		//assertEquals("You logged into a secure area!\n×" ,loginConfirm);
		
		SecureAreaPage secureAreaPage=loginPage.validLogin("tomsmith", "SuperSecretPassword!");
		String loginConfirm=secureAreaPage.getLoginMessage();
		assertEquals("You logged into a secure area!\n×" ,loginConfirm);
		
		String logoutConfirm=secureAreaPage.logout().getLogoutMessage();
		assertEquals("You logged out of the secure area!\n×",logoutConfirm);
		
	}

}
