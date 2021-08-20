package myshop.pageobjects_id.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingDetailsPage {
	
	@FindBy(id="shipping_house")
	public WebElement houseNumber;
	
	@FindBy(id="street")
	public WebElement street;
	
	@FindBy(id="town")
	public WebElement townCity;
	
	@FindBy(id="country")
	public WebElement country;
	
	@FindBy(id="submit")
	public WebElement submit;
}
