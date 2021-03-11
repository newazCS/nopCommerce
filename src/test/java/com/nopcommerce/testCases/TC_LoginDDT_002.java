package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException {
		
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		logger.info("URL IS OPENED.....");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		logger.info("User provided.....");
		
		lp.setUserPass(pwd);
		logger.info("User provided.....");
		
		lp.clickLogin();
		logger.info("Login in clicked.....");
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login passed.....");
		}else {
			//captureScreen(driver, "loginTest"); // This is Data driven test so you don't need it
			Assert.assertTrue(false);
			logger.info("Login failed.....");
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount =XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata [][]= new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0; j<colcount; j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
		
		
	}
	

}
