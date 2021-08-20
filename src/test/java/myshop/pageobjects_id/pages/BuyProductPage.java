package myshop.pageobjects_id.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProductPage {

	@FindBy(id = "quantity1")
	public WebElement quantity;

	@FindBy(id = "buy")
	public WebElement buy;

	@FindBy(id = "total1")
	public WebElement total_product;

	@FindBy(id = "checkout")
	private WebElement checkOut;

	public ShippingDetailsPage goToShippingDetails(WebDriver driver) {
		checkOut.click();
		return PageFactory.initElements(driver, ShippingDetailsPage.class);
	}

}
