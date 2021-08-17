package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {
	@FindBy(xpath="//label[text()='User Name']/following-sibling::input")
	public WebElement userName;
	
	@FindBy(xpath="//label[text()='Password']/following-sibling::input")
	public WebElement password;
	
	@FindBy(xpath="//label[text()='Re-Enter Password']/following-sibling::input")
	public WebElement reEnterPassword;
	
	@FindBy(xpath="//input[@value='Register']")
	public WebElement register;
}

