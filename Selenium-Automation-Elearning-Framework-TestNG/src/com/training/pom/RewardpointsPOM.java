package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RewardpointsPOM {
       private WebDriver driver; 
       
       public RewardpointsPOM(WebDriver driver) {
             this.driver = driver; 
             PageFactory.initElements(driver, this);
       }
       
       @FindBy(id="input-username")
       private WebElement userName; 
       
       @FindBy(id="input-password")
       private WebElement password;
       
       @FindBy(xpath="//*[@class='btn btn-primary' and @type='submit']")
       private WebElement loginBtn; 
             
       //Catlog options
       @FindBy(xpath="//*[@id='catalog']/ul/li[1]/a")
       private WebElement Catloglink;
       
       //Products link
       @FindBy(xpath="//*[@id='catalog']/ul/li[2]/a")
       private WebElement Productlink;
       
       //Add New Icon
       @FindBy(xpath="//*[@id='content']/div[1]/div/div/a")
       private WebElement AddNewIcon;
       
       //product name
       @FindBy(id="input-name1")
       private  WebElement productname;
       
       //Meta tag
       @FindBy(id="input-meta-title1")
       private WebElement Metatag;
       
       //Data Tab
       @FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
       private WebElement DataTab;
       
       //Model
       @FindBy(id="input-model")
       private WebElement Model;
       
       //price
       @FindBy(id="input-price")
       private WebElement Price;
       
       //Quantity
       @FindBy(id="input-quantity")
       private WebElement Quantity;
       
       //Links Tab
       @FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
       private WebElement LinkTab;
       
       //Categories
       @FindBy(id="input-category")
       private WebElement Categories;
       
       //Discounts Tab
       @FindBy(xpath="//*[@id='form-product']/ul/li[7]/a")
       private WebElement Discountstab;
       
       //Add Discounts button
       @FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
       private WebElement AddDiscountsbtn;
       
       //Quantity in Discounts tab
       @FindBy(name="product_discount[0][quantity]")
       private WebElement  QuantityDiscounts;
       
       //Price in Discounts tab
       @FindBy(name="product_discount[0][price]")
       private WebElement PriceDiscounts;
       
       //Rewards tab
       @FindBy(xpath="//*[@id=\"form-product\"]/ul/li[10]/a")
       private WebElement Rewardstab;
       
       //points in Rewards tab
       @FindBy(id="input-points")
       private WebElement points;
                    
       //Save button
       @FindBy(xpath="//*[@id='content']/div[1]/div/div/button/i")
       private WebElement Savebtn;
       
       public void sendUserName(String userName) {
             this.userName.clear();
             this.userName.sendKeys(userName);
       }
       
       public void sendPassword(String password) {
             this.password.clear(); 
             this.password.sendKeys(password); 
       }
       
       public void clickLoginBtn() {
             this.loginBtn.click(); 
       }
             
       public void clickCatlogOptions() {
             this.Catloglink.click();
       }
       
       public void clickProductsLink() {
             this.Productlink.click();
       }
       
       public void AddnewButton() {
             this.AddNewIcon.click();
       }
       
       public void sendProductName(String productname) {
             this.productname.clear();
             this.productname.sendKeys(productname);
       } 
       
       public void sendMetatag(String metatag) {
             this.Metatag.clear();
             this.Metatag.sendKeys(metatag);
       }
       
       public void ClickDataTab() {
             this.DataTab.click();
       }
       
       public void SendModel(String model) {
             this.Model.clear();
             this.Model.sendKeys(model);
       }
       
       public void sendPrice(String price) {
             this.Price.clear();
             this.Price.sendKeys(price);
       }
       
       public void sendQuantity(String quantity) {
             this.Quantity.clear();
             this.Quantity.sendKeys(quantity);
       }
       
       public void ClickLinkTab() {
             this.LinkTab.click();
       }
       
       public void FocusCategories() {
             this.Categories.click();
       }
       
       public void ClickDiscountsTab() {
             this.Discountstab.click();
       }
       
       public void ClickAddDiscounts() {
             this.AddDiscountsbtn.click();
       }
       
       public void SendQuantityDiscountsTab(String quantityDiscounts) {
             this.QuantityDiscounts.clear();
             this.QuantityDiscounts.sendKeys(quantityDiscounts);
       }
       
       public void SendPriceDiscountsTab(String priceDiscounts) {
             this.PriceDiscounts.clear();
             this.PriceDiscounts.sendKeys(priceDiscounts);
       }
       
       public void ClickRewardsTab() {
             this.Rewardstab.click();
       }
       
       public void SendPointsRewardsTab(String PointsRewards) {
             this.points.clear();
             this.points.sendKeys(PointsRewards);
       }
       
       public void ClickSavebtn() {
             this.Savebtn.click();
       }
}

