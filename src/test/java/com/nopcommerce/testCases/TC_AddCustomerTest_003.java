package com.nopcommerce.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		
		lp.setUserPass(password);
		logger.info("password is provided");
		
		lp.clickLogin();
		
		logger.info("providing customer details....");
		
		Thread.sleep(5000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		Thread.sleep(5000);
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		Thread.sleep(5000);
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Mohammad");
		addcust.setLastName("Newaz");
		
		addcust.setDob("02/06/1995"); // Format: D/MM/YYY
		
		addcust.setCompanyName("triageTechSolutions");
		addcust.setAdminContent("This is for testing.........");
	
		addcust.clickOnSave();
		
		logger.info("validation started....");
				
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}
	
	

}
