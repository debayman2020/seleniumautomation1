package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[starts-with(@class,'alert')]/button")
	private WebElement closeAlertBtn; 
	
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
	
	public void clickCloseAlertBtn(){
		this.closeAlertBtn.click();
	}
	
	public void scroll(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); 
		
	}
	
    public boolean LoginUser(String UserID,String Password)
    {
            try
            {
                    sendUserName(UserID);
                    sendPassword(Password);
                    clickLoginBtn();
                    return true;
                    
            }
            
            catch(Exception ex)
            {
                    System.out.println(ex.getMessage());
                    return false;
            }
    }
    
  
}
