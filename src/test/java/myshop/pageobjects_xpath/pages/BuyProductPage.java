package myshop.pageobjects_xpath.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProductPage {

	@FindBy(xpath = "//label[text()='Quantity']/following-sibling::input")
	public WebElement quantity;

	@FindBy(xpath = "//button/span[text()='Buy']")
	public WebElement buy;

	@FindBy(xpath = "//button/span[text()='Buy']/ancestor::a/following-sibling::div")
	public WebElement total_product;

	@FindBy(xpath = "//button/span[text()='Check Out']")
	private WebElement checkOut;

	public ShippingDetailsPage goToShippingDetails(WebDriver driver) {
		checkOut.click();
		return PageFactory.initElements(driver, ShippingDetailsPage.class);
	}

}
