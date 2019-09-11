package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority = 1)
	public void validLoginTest() throws InterruptedException {
		//Entering UserName
		loginPOM.sendUserName("srini.test@gmail.com");
		//Entering Password
		loginPOM.sendPassword("srini123");
		//Clicking on Login Button
		loginPOM.clickLoginBtn(); 
		//Clicking user Icon
		loginPOM.clickuserIcon();
		//Click on Order History
		loginPOM.clickOrderHistory();
		//Click on View Icon
		loginPOM.clickViewIcon();
		//Wait for 3secs
		Thread.sleep(3000);
		//screenShot.captureScreenShot("First");
	}
	
	@Test(priority = 2)
	public void validLoginTest2() throws InterruptedException {
		//Entering UserName
		loginPOM.sendUserName("dev.test@gmail.com");
		//Entering Password
		loginPOM.sendPassword("devs123");
		//Clicking on Login button
		loginPOM.clickLoginBtn(); 
		//Clicking on Edit Account
		loginPOM.clickEditaccount();
		//Clearing the Firstname textbox
		loginPOM.firstname();
		//Entering the value in Firstname field
		loginPOM.firstnameadd();
		//Clearing the Lastname textbox
		loginPOM.lastname();
		//Entering the value in Lastname field
		loginPOM.lastnameadd();
		//Clearing Email textbox
		loginPOM.email();
		//Entering the value in Email field
		loginPOM.addemail();
		//Clearing Telephone textbox
		loginPOM.telephone();
		//Entering the value in Telephone field
		loginPOM.addtelephone();
		//Clicking on Continue button
		loginPOM.update();
		Thread.sleep(3000);
		//Validating the Successfully updated message
		assertEquals(loginPOM.messageinfo(), "Success: Your account has been successfully updated.");
				
	}
	@Test(priority = 3)
	public void validLoginTest3() throws InterruptedException {
		//Entering UserName
		loginPOM.sendUserName("dev.test@gmail.com");
		//Entering Password
		loginPOM.sendPassword("devs123");
		//Clicking on Login button
		loginPOM.clickLoginBtn();
		//Clicking on Change Password link
		loginPOM.cpassword();
		//Entering the value in Password field
		loginPOM.inpassword();
		//Entering the value in Confirm Password field
		loginPOM.cnpassword();
		//Clicking on Continue button
		loginPOM.submit();
		//Validating the Successfully updated message
		assertEquals(loginPOM.messageinfos(), "Success: Your password has been successfully updated.");
		Thread.sleep(3000);

}
}


