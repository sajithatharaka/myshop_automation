package myshop.nopageobjects.scripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myshop.constants.Environment;

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
		driver.findElement(By.xpath("//span[text()='See Details']")).click();
		driver.findElement(By.xpath("//span[text()='Buy']")).click();
		driver.findElement(By.xpath("//label[text()='Quantity']/following-sibling::input")).sendKeys("10");	
		driver.findElement(By.xpath("//button/span[text()='Buy']")).click();
			
		String amount=driver.findElement(By.xpath("//button/span[text()='Buy']/ancestor::a/following-sibling::div")).getText();
		assertEquals(amount, "Rs. 28500", "Quantity is not equal to Rs. 28500");		
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}


