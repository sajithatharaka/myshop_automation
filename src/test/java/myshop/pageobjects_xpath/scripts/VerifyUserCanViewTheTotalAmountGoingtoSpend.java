package myshop.pageobjects_xpath.scripts;

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
import myshop.pageobjects_xpath.pages.BuyProductPage;
import myshop.pageobjects_xpath.pages.HomePage;

public class VerifyUserCanViewTheTotalAmountGoingtoSpend {
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
		home.seeDetailsFirstItem.click();
		BuyProductPage productDetailsPage=home.goToBuyProductPagePage(driver);
		productDetailsPage.quantity.sendKeys("10");	
		productDetailsPage.buy.click();
		assertEquals(productDetailsPage.total_product.getText(), "Rs. 28500", "Quantity is not equal to Rs. 28500");		
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}

