
package com.training.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM2 {
               private WebDriver driver; 
               public LoginPOM2(WebDriver driver) {
                              this.driver = driver; 
                              PageFactory.initElements(driver, this);
               }
               
               @FindBy(xpath ="//div[@id = 'banner0']/div/a/img")
               private WebElement ShopUniform; 
               
               @FindBy(xpath = "//*[@id= 'featured-grid']/div[2]/div/div/div/a/img")
               private WebElement RegularTshirts;
               
               @FindBy(xpath ="//*[@name='option[376]']")
               private WebElement Chestsize;
               
               @FindBy(id = "button-cart")
               private WebElement addcart;
               
               @FindBy(id = "cart")
               private WebElement carticon;
               
               @FindBy(xpath = "//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/a")
               private WebElement cartitems;
               
               @FindBy(xpath = "//*[@id='cart']/ul/li[2]/div/p/a[1]/strong")
               private WebElement viewcart;
               
               @FindBy(xpath = "//*[@id= 'content']/div[2]/div[2]/a")
               private WebElement checkout;
               
               @FindBy(xpath = "//a[@class= 'btn btn-primary']")
               private WebElement checkingout;
               
               @FindBy(xpath = "//*[@value = 'guest']")
               private WebElement guest;
               
               @FindBy(id = "button-account")
               private WebElement continuebutton;
               
               @FindBy(name = "firstname")
               private WebElement firstname;
               
               @FindBy(name = "lastname")
               private WebElement lastname;
               
               @FindBy(id = "input-payment-email")
               private WebElement email;
               
               @FindBy(name = "telephone")
    private WebElement telephone;
               
               @FindBy(name = "address_1")
               private WebElement address1;
               
               
               @FindBy(name = "city")
               private WebElement city;
               
               
               @FindBy(name = "address_1")
               private WebElement address;
               
               @FindBy(name = "postcode")
               private WebElement postcode;
               
               @FindBy(name = "shipping_address")
               private WebElement deladdresschckbox;
               
               @FindBy(xpath = "//*[@id = 'button-guest']")
               private WebElement continuecheckout;
               
               @FindBy(name = "comment")
               private WebElement comments;
               
               @FindBy(xpath="//*[@id='button-shipping-method']")
               private WebElement step4continue;
               
               public void clickonstep4continue() {
                   
                   this.step4continue.click();
                }
               
              // @FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
               @FindBy(name="agree")
               private WebElement agreecheckbox;
               
               public void clickonagreecheckbox() {

                   this.agreecheckbox.click();
                }
               
               @FindBy(xpath="//*[@id='button-payment-method']")
               private WebElement step5continue;
               
               public void clickonstep5continue() {
                   
                   this.step5continue.click();
                }
               
               @FindBy(id = "button-confirm")
               private WebElement confirmorder;
               
               @FindBy(id = "content")
               private WebElement content;
               
               @FindBy(id = "input-payment-zone")
               private WebElement state;
               



public void clickonconfirmorder() {

                  this.confirmorder.click();
               }

public void Entercomments(String comments) {

                  this.comments.sendKeys(comments);;
               }

public void clickonRegularTshirts() {
               
               this.RegularTshirts.click();
}


public void selectchestsize(String value) {
               
               Select sel = new Select(this.Chestsize);
               sel.selectByValue(value);
               
}

public void clickonaddcart()
{
               this.addcart.click();

}


public String gotocart()

{
               String item = this.cartitems.toString();
               
               Actions ac =  new Actions(driver);
               Action mouseover = ac.moveToElement(carticon).click().build();
               mouseover.perform();
               
               System.out.println(item);
               
               return item;
               

}


public void clickoncart()

{              
   this.viewcart.click();
   
}

public void clickoncheckout()
{              

               this.checkout.click();
               
               
}

public void Enterpersonaldetails(String firstname,String lastname,String email,String phoneno,String statename,
               String address,String address1,
               String city,String postalcode        )
{
               
this.firstname.sendKeys(firstname);
this.lastname.sendKeys(lastname);
this.email.sendKeys(email);
this.telephone.sendKeys(phoneno);
this.address.sendKeys(address);
this.address1.sendKeys(address1);
this.city.sendKeys(city);
this.postcode.sendKeys(postalcode);

 Select sel = new Select(this.state);
sel.selectByVisibleText(statename);

 
}

public void Clickondeliveryaddresscheckbox()
{
               this.deladdresschckbox.click();

}


public void Clickoncheckingout()
{
               this.checkingout.click();

}



public void Clickingonguestaccount()
{
               this.guest.click();

}

public void Clickingocontinuebutton()
{
               this.continuebutton.click();

}

public void Clickingcontinuingcheckout()
{
  this.continuecheckout.click();    

}

//public String getcontentafterorderplacing()
//{
  //String contxt = this.content.getText();
  //System.out.println(contxt);
  //return contxt;
  
//}

public void clickonShopUniform() {
                              this.ShopUniform.click();
               
}


}





