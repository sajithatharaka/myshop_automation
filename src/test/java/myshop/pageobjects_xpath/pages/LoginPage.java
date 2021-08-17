package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath="//label[text()='User Name']/following-sibling::input")
	public WebElement userName;
	
	@FindBy(xpath="//label[text()='Password']/following-sibling::input")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement login;
	
}
