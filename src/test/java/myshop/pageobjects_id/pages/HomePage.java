package myshop.pageobjects_id.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		
	@FindBy(id="product-1")
	public WebElement seeDetailsFirstItem;	
	
	@FindBy(id="logeed-user")
	public WebElement loggedInUserName;
	
	@FindBy(id="logout")
	public WebElement logout;
	
	@FindBy(id="login")
	public WebElement login;
	
	@FindBy(id="signup")
	public WebElement signUp;
	
	
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
