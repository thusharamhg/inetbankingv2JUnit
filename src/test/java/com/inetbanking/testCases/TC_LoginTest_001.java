package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
	
	public TC_LoginTest_001(String browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loginTest() throws IOException
	{
		logger.info("URL is Opened");      //Just to logger information purpose
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
