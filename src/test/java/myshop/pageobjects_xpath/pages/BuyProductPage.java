package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyProductPage {
	
	@FindBy(xpath="//label[text()='Quantity']/following-sibling::input")
	public WebElement quantity;
	
	@FindBy(xpath="//button/span[text()='Buy']")
	public WebElement buy;
	
	@FindBy(xpath="//button/span[text()='Buy']/ancestor::a/following-sibling::div")
	public WebElement total_product;

}
