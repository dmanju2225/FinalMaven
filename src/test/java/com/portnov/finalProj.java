package com.portnov;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class finalProj {
private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/login");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
		WebElement user=driver.findElement(By.xpath("//*[@id='username']"));
		user.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		WebElement login=driver.findElement(By.xpath("//*[@id='login']/button"));
		login.click();
		WebElement loggedin=driver.findElement(By.xpath("//*[@id='flash']/"));
		System.out.println(loggedin.getText());
		
		assertEquals("You logged into a secure area!" ,loggedin.getText());
		
		WebElement logout=driver.findElement(By.xpath("//*[@id='content']/div/a"));
		logout.click();
		WebElement loggedout=driver.findElement(By.xpath("//*[@id='flash']"));
		System.out.println(loggedout.getText());
		assertEquals("You logged out of the secure area! " ,loggedout.getText());
	}

}
