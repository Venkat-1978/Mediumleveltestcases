package com.training.sanity.tests;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RewardpointsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RewardpointsTests {

       private WebDriver driver;
       private String baseUrl1;
       private RewardpointsPOM MLevelTestcase4pom;
       private static Properties properties;
       private ScreenShot screenShot;

       @BeforeClass
       public static void setUpBeforeClass() throws IOException {
             properties = new Properties();
             FileInputStream inStream = new FileInputStream("./resources/others.properties");
             properties.load(inStream);
       }

       @BeforeMethod
       public void setUp() throws Exception {
             driver = DriverFactory.getDriver(DriverNames.CHROME);
             MLevelTestcase4pom = new RewardpointsPOM(driver); 
             baseUrl1 = properties.getProperty("baseURL1");
             screenShot = new ScreenShot(driver);
             // open the browser 
             driver.get(baseUrl1);
             
       }
       
       @AfterMethod
       public void tearDown() throws Exception {
             Thread.sleep(1000);
             //Close the all browsers
             driver.quit();
       }
       @Test
       public void TestCase3() throws InterruptedException {
             
             //enter valid credentials in Username textbox
             MLevelTestcase4pom.sendUserName("admin");
             //enter valid credentials in Password textbox
             MLevelTestcase4pom.sendPassword("admin@123");
             //click on Login button
             MLevelTestcase4pom.clickLoginBtn(); 
             
             //Verifying Dashboard Title for login successful webpage
             String ExpectedTitle="Dashboard";
             String ActualTitle=driver.getTitle();
             if(ActualTitle.contentEquals(ExpectedTitle)) {
                    Assert.assertEquals(ActualTitle, ExpectedTitle);
             }
             else {
                    Assert.fail();
             }
             
             screenShot.captureScreenShot("First");
             
             System.out.println("Testcase 3 : Step 1 : Click on Catolog icon and display the list of links");
             
             //Move the element to Catlog icon
             Actions action=new Actions(driver);
             WebElement obj=driver.findElement(By.xpath("//*[@id='catalog']/a/i"));
             action.moveToElement(obj).build().perform();
             obj.click();
             
             //Actual list of Catlog links
             String[] Actuallistdata={"Categories", "Products", "Recurring Profiles", "Filters", "Attributes", "Options", "Manufacturers", "Downloads", "Reviews", "Information"};
             String Expectedlistdata;  
             List<WebElement> Catloglinks = driver.findElements(By.xpath("//*[@id='catalog']/ul/li/a"));
             System.out.println(Catloglinks.size());
             //Gettting the list of Catlog links
             for(int i=0;i<Catloglinks.size();i++) {
                    Expectedlistdata=Catloglinks.get(i).getText();
                    System.out.println(Expectedlistdata);
                    System.out.println(Actuallistdata[i]);
                    if(Expectedlistdata.equals(Actuallistdata[i])) {
                           Assert.assertEquals(Actuallistdata[i], Expectedlistdata);
                           System.out.println("The Actual list Data "+ Actuallistdata[i] + " and The Expected data list " + Expectedlistdata + "is same hence the testcase pass");
                    }
                    else
                    {
                           Assert.fail();
                           System.out.println("test case failed");
                    }
             }      
             
             System.out.println("testcase 3: Step 2 : click on products link in Catlog and display the list of Categories");
             
             // click on products link
             MLevelTestcase4pom.clickProductsLink();
             
             String ProductListData;
             List<WebElement> ProductList = driver.findElements(By.xpath("//*[@id='form-product']/div/table/tbody/tr/td"));
             //Getting the list of Categories
             for(int i=0;i<ProductList.size();i++) {
                    ProductListData = ProductList.get(i).getText();
                    System.out.println(ProductListData);
             }
             
             //Click on Add New Button
             MLevelTestcase4pom.AddnewButton();
             
             String ExpectedAddNewTitle="Add Product";
             String ActualAddNewTitle=driver.findElement(By.xpath("//*[contains(text(),'Add Product')]")).getText();
             System.out.println(ActualAddNewTitle);
             
             if(ActualAddNewTitle.contentEquals(ExpectedAddNewTitle)) {
                    Assert.assertEquals(ActualAddNewTitle, ExpectedAddNewTitle);
                    System.out.println("PASS");
             }
             else 
             {
                    Assert.fail();
                    System.out.println("Fail");
             }
             
             //Product name
             MLevelTestcase4pom.sendProductName("Blazer Girls(7-8)");
             String Actualproductname=driver.findElement(By.id("input-name1")).getAttribute("value");
             System.out.println(Actualproductname);
             String Expectedproductname="Blazer Girls(7-8)";
             
             if(Actualproductname.contentEquals(Expectedproductname)) {
                    Assert.assertEquals(Actualproductname, Expectedproductname);
                    System.out.println("product name are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("product names are not equal");
             }
             
             //Meta Tag
             MLevelTestcase4pom.sendMetatag("Blazer for Girls");
             String ActualMetatag=driver.findElement(By.id("input-meta-title1")).getAttribute("value");
             System.out.println(ActualMetatag);
             String ExpectedMetatag="Blazer for Girls";
             
             if(ActualMetatag.contentEquals(ExpectedMetatag)) {
                    Assert.assertEquals(ActualMetatag, ExpectedMetatag);
                    System.out.println("Model are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Model are not equal");
             }
             
             //Click on Data tab
             MLevelTestcase4pom.ClickDataTab();
             
             //Model
             MLevelTestcase4pom.SendModel("BLG-112");
             String ActualModel=driver.findElement(By.id("input-model")).getAttribute("value");
             System.out.println(ActualModel);
             String ExpectedModel="BLG-112";
             
             if(ActualModel.contentEquals(ExpectedModel)) {
                    Assert.assertEquals(ActualModel, ExpectedModel);
                    System.out.println("Model are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Model are not equal");
             }
             
             //Price
             MLevelTestcase4pom.sendPrice("3000");
             String Actualprice=driver.findElement(By.id("input-price")).getAttribute("value");
             System.out.println(Actualprice);
             String Expectedprice="3000";
             
             if(Actualprice.contentEquals(Expectedprice)) {
                    Assert.assertEquals(Actualprice, Expectedprice);
                    System.out.println("price are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("price names are not equal");
             }
             
             //Quantity
             MLevelTestcase4pom.sendQuantity("100");
             String ActualpQuantity=driver.findElement(By.id("input-quantity")).getAttribute("value");
             System.out.println(ActualpQuantity);
             String ExpectedQuantity="100";
             
             if(ActualpQuantity.contentEquals(ExpectedQuantity)) {
                    Assert.assertEquals(ActualpQuantity, ExpectedQuantity);
                    System.out.println("Quantity are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Quantity are not equal");
             }
             
             //Click On Links Tab
             MLevelTestcase4pom.ClickLinkTab();
             Thread.sleep(3000);
             //Categories
             MLevelTestcase4pom.FocusCategories();
             Thread.sleep(3000);
             driver.findElement(By.id("input-category")).sendKeys("Blazers(3-5)");
             Thread.sleep(3000);
             
             Actions Act=new Actions(driver);
             Act.sendKeys(Keys.TAB,Keys.ENTER).perform();
             
             String ExpectedCategoriestext="Blazers(3-5)";
             String ActualCategoriestext=driver.findElement(By.xpath("//*[@id='product-category']")).getText();
             System.out.println("Categories text is"+ExpectedCategoriestext);
             
             if(ActualCategoriestext.contentEquals(ExpectedCategoriestext)) {
                    Assert.assertEquals(ActualCategoriestext, ExpectedCategoriestext);
                    System.out.println("Categories text are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Categories text are equal");
             }
             
             
             //Discounts tab
             MLevelTestcase4pom.ClickDiscountsTab();
             //Add Discounts buttom
             MLevelTestcase4pom.ClickAddDiscounts();
             
             //Quantity in Discounts tab
             MLevelTestcase4pom.SendQuantityDiscountsTab("5");
             
             String ActualQuantityDiscounts=driver.findElement(By.name("product_discount[0][quantity]")).getAttribute("value");
             System.out.println(ActualQuantityDiscounts);
             String ExpectedQuantityDiscounts="5";
             
              if(ActualQuantityDiscounts.contentEquals(ExpectedQuantityDiscounts)) {
                    Assert.assertEquals(ActualQuantityDiscounts, ExpectedQuantityDiscounts);
                    System.out.println("Quantity are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Quantity are not equal");
             }
             
             //price in Discounts tab
             MLevelTestcase4pom.SendPriceDiscountsTab("200");
             String ActualpriceDiscounts=driver.findElement(By.name("product_discount[0][price]")).getAttribute("value");
             System.out.println(ActualpriceDiscounts);
             String ExpectedpriceDiscounts="200";
             
             if(ActualpriceDiscounts.contentEquals(ExpectedpriceDiscounts)) {
                    Assert.assertEquals(ActualpriceDiscounts, ExpectedpriceDiscounts);
                    System.out.println("price are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("price are not equal");
             }
             
             //Start Date
             driver.findElement(By.xpath("//*[@id='discount-row0']/td[5]/div/span/button")).click();
             Thread.sleep(3000);
             //End Date
             driver.findElement(By.xpath("//*[@id='discount-row0']/td[6]/div/span/button")).click();      
             Thread.sleep(3000);
             
             //Rewards tab
             MLevelTestcase4pom.ClickRewardsTab();
             
             //Points in Rewards tab
             MLevelTestcase4pom.SendPointsRewardsTab("20");
             String ActualRewards=driver.findElement(By.id("input-points")).getAttribute("value");
             System.out.println(ActualRewards);
             String ExpectedPoints="20";
             
             if(ActualRewards.contentEquals(ExpectedPoints)) {
                    Assert.assertEquals(ActualRewards, ExpectedPoints);
                    System.out.println("Points are equal");
             }
             else {
                    Assert.fail();
                    System.out.println("Points are not equal");
             }
             
             
             //Same values we kept for all tabs
             //Attribute tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[4]/a")).click();
             //Option tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[5]/a")).click();
             //Recurring tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[6]/a")).click();
             //Special tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[8]/a")).click();
             //Image tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[9]/a")).click();
             //Design tab
             driver.findElement(By.xpath("//*[@id=\"form-product\"]/ul/li[11]/a")).click();
             
             MLevelTestcase4pom.ClickSavebtn();
             
             String SaveMessage=driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).getText();
             System.out.println("Save message is :"+SaveMessage);
             
       if(driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]")).isDisplayed()) {
                    System.out.println("The Save message should be displayed");
             }
             else
             {
                    Assert.fail();
             }
       }
}      
