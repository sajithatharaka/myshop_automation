package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logOut;
	
	
	@FindBy(xpath="//span[text()='See Details'][1]")
	public WebElement seeDetailsFirstItem;	
	
	@FindBy(xpath="//div[text()='Hi John, Welcome back !']")
	public WebElement loggedInUserName;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout;
	
	@FindBy(xpath="//a[text()='Login']")
	public WebElement login;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	private WebElement signUp;
	
	@FindBy(xpath="//span[text()='See Details']")
	private WebElement seeDetails;
	
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
	
	public LoginPage goToProductDetailsPage(WebDriver driver) {
		seeDetails.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public BuyProductPage goToBuyProductPagePage(WebDriver driver) {
		buy.click();
		return PageFactory.initElements(driver, BuyProductPage.class);
	}
}
