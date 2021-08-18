package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingDetailsPage {
	
	@FindBy(xpath="//label[text()='House Number']/following-sibling::input")
	public WebElement houseNumber;
	
	@FindBy(xpath="//label[text()='Street']/following-sibling::input")
	public WebElement street;
	
	@FindBy(xpath="//label[text()='Town/City']/following-sibling::input")
	public WebElement townCity;
	
	@FindBy(xpath="//label[text()='Country']/following-sibling::input")
	public WebElement country;
	
	@FindBy(xpath="//input[@id='submit']")
	public WebElement submit;
}
