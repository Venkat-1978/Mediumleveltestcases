package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Test case 1
	//Finding E-MailAddress field
	@FindBy(xpath="//*[@id='input-email']")
	private WebElement userName; 
	//Method to enter email address
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	//Finding Password field
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	//Method to enter password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	//Finding Login button
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 
	//Method to click "Login" button		
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	//Finding user icon
	@FindBy(xpath="//*[@class='dropdown-toggle']")
	private WebElement userIcon;
	//Method to click user icon
	public void clickuserIcon()
	{
		this.userIcon.click();
	}
	
	//Finding Order History Option
	@FindBy(linkText="Order History")
	private WebElement OrderHistory;
	//Clicking on Order History option
	public void clickOrderHistory()
	{
		this.OrderHistory.click();
	}
	//Finding View Icon
	@FindBy(xpath="//*[@class='btn btn-info']")
	private WebElement ViewIcon;
	// Method to click on view icon
	public void clickViewIcon()
	{
		this.ViewIcon.click();
	}
	// End of test case 1
	
	// Beginning of test case 2
	
	//Finding Edit Account link
	@FindBy(linkText="Edit your account information")
	private WebElement Editaccount;
	//Method to click on Edit Account
	public void clickEditaccount()
	{
		this.Editaccount.click();
	}
	//Finding the First Name Field
	@FindBy(xpath="//*[@id='input-firstname']")
	private WebElement firstname;
	//Method to clear the value in Firstname textbox
	public void firstname()
	{
		this.firstname.clear();
	}
	//Finding the First Name Field
	@FindBy(xpath="//*[@id='input-firstname']")
	private WebElement firstnameadd;
	//Method to add value in First name field
	public void firstnameadd()
	{
		this.firstnameadd.sendKeys("Neha");
	}
	//Finding the LastName Field
	@FindBy(xpath="//*[@id='input-lastname']")
	private WebElement lastname;
	//Method to clear the value in Lastname textbox
	public void lastname()
	{
		this.lastname.clear();
	}
	//Finding the LastName Field
	@FindBy(xpath="//*[@id='input-lastname']")
	private WebElement lastnameadd;
	
	//Method to add value in Lastname field
	public void lastnameadd()
	{
		this.lastnameadd.sendKeys("B");
    }
	
	//Finding the Email Address Field
	@FindBy(xpath="//*[@id='input-email']")
	private WebElement email;
	
	//Method to clear  value in Email field
	public void email()
	{
		this.email.clear();
    }
	
	//Finding the Email Address Field
	@FindBy(xpath="//*[@id='input-email']")
	private WebElement addemail;
	
	//Method to add value in Email field
	public void addemail()
	{
		this.addemail.sendKeys("dev.test@gmail.com");
	}
	
	//Finding the Telephone Field
	@FindBy(xpath="//*[@id='input-telephone']")
	private WebElement telephone;
	
	//Method to clear  value in telephone field
	public void telephone()
	{
		this.telephone.clear();
	}
	
	//Finding the Telephone Field
	@FindBy(xpath="//*[@id='input-telephone']")
	private WebElement addtelephone;
	
	//Method to add value in Telephone field
	public void addtelephone()
	{
		this.addtelephone.sendKeys("9111111110");
	}
	
	//Finding Continue button
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	private WebElement update;
	
	// Method to click on Continue button
	public void update()
	{
		this.update.click();
		
	}
	
	//Finding the successfully updated message
	@FindBy(xpath="//*[@class = \"alert alert-success\"]")
	private WebElement messageinfo;
	//Method to get the successfully updated text
	public String messageinfo()
	{
		return this.messageinfo.getText();
		
	}
	
	//End of testcase 2
	
	//Beginning of testcase 3
	//Finding the link for change your password
	@FindBy(linkText="Change your password")
	private WebElement cpassword;
	//Method to click on change your password
	public void cpassword()
	{
		this.cpassword.click();
	}
	//Finding Password textbox
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement inpassword;
	//Method to enter the value in Password textbox
	public void inpassword()
	{
		this.inpassword.sendKeys("devs123");
	}
	//Finding the Password Confirm textbox
	@FindBy(xpath="//*[@id='input-confirm']")
	private WebElement cnpassword;
	public void cnpassword()
	//Method to enter the value in Password Confirm textbox
	{
		this.cnpassword.sendKeys("devs123");
	}
	//Finding the Continue button
	@FindBy(xpath="//*[@type='submit' and @value='Continue']")
	private WebElement submit;
	//Method to click the Continue button
	public void submit()
	{
		this.submit.click();
	}
	//Finding the Password successfully updated message
	@FindBy(xpath="//*[@class=\"alert alert-success\"]")
	private WebElement messageinfos;
	//Method to get the Password successfully updated text
	public String messageinfos()
	{
		return this.messageinfos.getText();
		
	}
}



	

