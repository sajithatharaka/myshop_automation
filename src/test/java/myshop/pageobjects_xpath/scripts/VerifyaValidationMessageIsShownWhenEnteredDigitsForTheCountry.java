package myshop.pageobjects_xpath.scripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myshop.constants.Environment;
import myshop.pageobjects_xpath.pages.ProductDetailsPage;
import myshop.pageobjects_xpath.pages.BuyProductPage;
import myshop.pageobjects_xpath.pages.HomePage;
import myshop.pageobjects_xpath.pages.ShippingDetailsPage;

public class VerifyaValidationMessageIsShownWhenEnteredDigitsForTheCountry {
	private WebDriver driver;
	private Environment environment = Environment.DEFAULT;

	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get(environment.getBaseURL());
	}

	@Test
	public void verifyLogin() throws InterruptedException {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ProductDetailsPage productDetailsPage=home.goToFirstProductDetailsPage(driver);
		BuyProductPage buyProductPage=productDetailsPage.goToBuy(driver);
		
		buyProductPage.quantity.sendKeys("10");	
		buyProductPage.buy.click();
		ShippingDetailsPage shippingDetails=buyProductPage.goToShippingDetails(driver);
		shippingDetails.houseNumber.sendKeys("1");
		shippingDetails.country.sendKeys("12");
		shippingDetails.submit.click();

		WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Please enter a correct name for the country to proceed", "Alert message was not - Please enter a correct name for the country to proceed");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
