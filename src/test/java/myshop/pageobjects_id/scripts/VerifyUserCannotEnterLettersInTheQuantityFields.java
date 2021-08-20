package myshop.pageobjects_id.scripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myshop.constants.Environment;
import myshop.pageobjects_id.pages.BuyProductPage;
import myshop.pageobjects_id.pages.HomePage;
import myshop.pageobjects_id.pages.ProductDetailsPage;

public class VerifyUserCannotEnterLettersInTheQuantityFields {
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

		buyProductPage.quantity.sendKeys("abc");	
		assertEquals(buyProductPage.quantity.getAttribute("value"), "", "Quantity is not empty");			
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
