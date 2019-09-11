package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnOrderPOM {
       
       private WebDriver driver; 
       
       public ReturnOrderPOM(WebDriver driver) {
       this.driver = driver; 
             PageFactory.initElements(driver, this);
       }
       //Finding Username
       @FindBy(xpath="//*[@id='input-email']")
       private WebElement userName ;
       
       //username method
       public void sendUserName(String userName) {
                    this.userName.clear();
                    this.userName.sendKeys(userName);
             }
       
       //Finding Password  
       @FindBy(xpath="//*[@id='input-password']")
       private WebElement password;
       //password method
       public void sendPassword(String password) {
             this.password.clear(); 
             this.password.sendKeys(password); 
       }
       //Clicking on login button
       @FindBy(xpath="//*[@type='submit']")
       private WebElement loginBtn; 
       
       //login button method     
                           public void clickLoginBtn() {
                                 this.loginBtn.click(); 
                           }
       //Finding dropdown user icon
       @FindBy(xpath="//*[@class='dropdown-toggle']")
       private WebElement Usericon;
       
       //Click on UserIcon
       public void clickUserIcon() throws InterruptedException {
             this.Usericon.click();
             Thread.sleep(2000);
             }
       
       //Finding Order History Link
       @FindBy(linkText="Order History")
       private WebElement OrderHistory;
       
       //Click on OrderHistory Link
       public void clickOrderHistory() {
             this.OrderHistory.click(); 
       }
       
       //Finding View Icon
       @FindBy(xpath="//*[@class='btn btn-info']")
       private WebElement ViewIcon;
       
       //Click on ViewIcon
       public void clickViewIcon() {
             this.ViewIcon.click();
       }
       
       //Finding Return Icon
       @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a[2]")
       private WebElement ReturnIcon;
       
       //Click on ViewIcon
             public void clickReturnIcon() {
                    this.ReturnIcon.click();
             }
             
       //Clicking on Order Error Radio button
@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[3]/label")
       private WebElement OrderError;
       
       //Click on Order Error
       public void clickOrderError() {
                    
             this.OrderError.click();
       }
       
       //Checking Product radio button
@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[5]/div/label[1]/input")
       private WebElement ProductOpened;
       
       //Click on Product Opened
       public void clickProductOpened() throws InterruptedException {
                      Thread.sleep(2000);
                     JavascriptExecutor js = (JavascriptExecutor) driver;
                     js.executeScript("window.scrollBy(0,400)");
                           this.ProductOpened.click();
                           Thread.sleep(1000);
                           }
       
       //Finding faulty or other details box
       @FindBy(xpath="//*[@id='input-comment']")
       private WebElement reason;
       
       //Click on Faulty or Other Details box and entering the ReasonforReturn
       public void sendreasonforreturn(String reason) {
             this.reason.clear(); 
             this.reason.sendKeys(reason); 
       }
       
       //Finding Agree Check Box
       @FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input[1]")
       private WebElement Agree;
             
       //Check Agree check box
       public void clickAgree() {
             this.Agree.click();
       }
       
       //Finding Submit Button
       @FindBy(xpath="//*[@class='btn btn-primary']")
       private WebElement Submit;
       
       //Click on Submit button
       public void clickSubmit() {
             this.Submit.click();
       }
}

