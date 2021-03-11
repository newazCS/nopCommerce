package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL IS OPENED.....");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User provided.....");
		
		lp.setUserPass(password);
		logger.info("User provided.....");
		
		lp.clickLogin();
		logger.info("Login in clicked.....");
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed.....");
		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed.....");
		}
	}
}
