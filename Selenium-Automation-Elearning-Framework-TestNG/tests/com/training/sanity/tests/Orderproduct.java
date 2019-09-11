package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Orderproduct {

               private WebDriver driver;
               private String orderURL;
               private LoginPOM2 LoginPOM2;
               private static Properties properties;
              // private ScreenShot screenShot;

               @BeforeClass
               public static void setUpBeforeClass() throws IOException {
                              properties = new Properties();
                              FileInputStream inStream = new FileInputStream("./resources/others.properties");
                              properties.load(inStream);            
               }

               @BeforeMethod
               public void setUp() throws Exception {
                              driver = DriverFactory.getDriver(DriverNames.CHROME);
                              LoginPOM2 = new LoginPOM2(driver);
               
                              orderURL = properties.getProperty("orderURL");
                              //screenShot = new ScreenShot(driver); 
                              // open the browser 
                              driver.get(orderURL);
               }
               
               @AfterMethod
               public void tearDown() throws Exception {
                              Thread.sleep(1000);
                              driver.quit();
               }
               @Test()
               public void validLoginTest() throws InterruptedException {
                              
               LoginPOM2.clickonShopUniform();
               LoginPOM2.clickonRegularTshirts();
               LoginPOM2.selectchestsize("963");//selecting the size by value
               LoginPOM2.clickonaddcart();
               LoginPOM2.gotocart();
               LoginPOM2.clickoncart();
               LoginPOM2.Clickoncheckingout();
               LoginPOM2.Clickingonguestaccount();
               LoginPOM2.Clickingocontinuebutton();
               
               LoginPOM2.Enterpersonaldetails("venkat", "munu", "venkat.munu@gmail.com", "1234567890","Tamil Nadu", "7-12-32", "Ramapuram", "Chennai", "600089");
               LoginPOM2.Clickingcontinuingcheckout();
               LoginPOM2.Entercomments("My order");
               Thread.sleep(2000);
               LoginPOM2.clickonstep4continue();
               Thread.sleep(2000);
              // LoginPOM2.clickonagreecheckbox();
               
               if(driver.findElement(By.name("agree")).isSelected()) {
            	   LoginPOM2.clickonstep5continue();
               }
               else {
            	   driver.findElement(By.name("agree")).click();
            	   LoginPOM2.clickonstep5continue();
               }
               
               //LoginPOM2.clickonstep5continue();
               LoginPOM2.clickonconfirmorder();
          
                 String ExpectedMsg = "Your order has been successfully processed!";
                 String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),'Your order has been successfully processed!')]")).getText();
               //Printing the Actual Msg in console
                 System.out.println(ActualMsg);
               //Validating whether Expected message & Actual message are matching or not
                 Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
               
               
               
}
}

