package myshop.nopageobjects.scripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import myshop.constants.Environment;

public class VerifyaValidationMessageIsShownWhenTheCountryIsEmpty {
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
		driver.findElement(By.xpath("//span[text()='See Details'][1]")).click();
		driver.findElement(By.xpath("//button/span[text()='Buy']")).click();
		driver.findElement(By.xpath("//label[text()='Quantity']/following-sibling::input")).sendKeys("10");
		driver.findElement(By.xpath("//button/span[text()='Buy']")).click();
		driver.findElement(By.xpath("//button/span[text()='Check Out']")).click();		
		driver.findElement(By.xpath("//label[text()='House Number']/following-sibling::input")).sendKeys("1");
		driver.findElement(By.xpath("//label[text()='Country']/following-sibling::input")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(), "Please enter a country to proceed", "Alert message was not - Please enter a country to proceed");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
