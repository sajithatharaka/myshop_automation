package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	@FindBy(xpath ="//span[text()='Buy']")
	public WebElement buy;
	

	public BuyProductPage goToBuy(WebDriver driver) {
		buy.click();
		return PageFactory.initElements(driver, BuyProductPage.class);
	}
	
}
