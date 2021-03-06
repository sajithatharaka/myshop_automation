package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//span[text()='See Details'][1]")
	public WebElement seeDetailsFirstItem;	
	
	@FindBy(xpath="//span[text()='Hi John, Welcome back !']")
	public WebElement loggedInUserName;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="//a[text()='Login']")
	public WebElement login;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	public WebElement signUp;	

	@FindBy(xpath="//span[text()='Buy']")
	private WebElement buy;
	
	
	public SignupPage goToSignUp(WebDriver driver) {
		signUp.click();
		return PageFactory.initElements(driver, SignupPage.class);
	}
	
	public LoginPage goToLogin(WebDriver driver) {
		login.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public ProductDetailsPage goToFirstProductDetailsPage(WebDriver driver) {
		seeDetailsFirstItem.click();
		return PageFactory.initElements(driver, ProductDetailsPage.class);
	}
}
