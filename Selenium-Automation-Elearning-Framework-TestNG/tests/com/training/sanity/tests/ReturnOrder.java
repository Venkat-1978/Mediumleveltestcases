package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.ReturnOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnOrder {
       
       private WebDriver driver;
       private String returnUrl;
       private ReturnOrderPOM ReturnOrderPOM;
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
             ReturnOrderPOM = new ReturnOrderPOM(driver); 
             returnUrl = properties.getProperty("returnURL");
             //screenShot = new ScreenShot(driver); 
             // open the browser 
             driver.get(returnUrl);
       }
       
       @AfterMethod
       public void tearDown() throws Exception {
             Thread.sleep(1000);
             driver.quit();
       }
       @Test
       public void MediumTestcase1() throws InterruptedException {
             //Entering the userName
             ReturnOrderPOM.sendUserName("arun.test@gmail.com");
             //Entering the Password
             ReturnOrderPOM.sendPassword("arun123");
             //Clicking on Login button
             ReturnOrderPOM.clickLoginBtn(); 
             //Clicking on UserIcon 
             ReturnOrderPOM.clickUserIcon();
             //Click on OrderHistory
             ReturnOrderPOM.clickOrderHistory();
             Thread.sleep(2000);
             //Click on View Icon
             ReturnOrderPOM.clickViewIcon();
             Thread.sleep(2000);
             //Click on Return Icon
             ReturnOrderPOM.clickReturnIcon();
             //Click on OrderError
             ReturnOrderPOM.clickOrderError();
             //Click on Product Opened
             ReturnOrderPOM.clickProductOpened();
             Thread.sleep(2000);
             ReturnOrderPOM.sendreasonforreturn("Incorrect Item");
             //Click on Agree button
             ReturnOrderPOM.clickAgree();
             Thread.sleep(1000);
             ReturnOrderPOM.clickSubmit();
             String ExpectedMsg = "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.";
             String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),'Thank you for submitting your return request. Your request has been sent to the relevant department for processing.')]")).getText();
             //Printing the Actual Msg in console
             System.out.println(ActualMsg);
             //Validating whether Expected message & Actual message are matching or not
             Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
                    
}
}
