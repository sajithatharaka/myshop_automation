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
		driver.findElement(By.xpath("//span[text()='See Details']")).click();
		driver.findElement(By.xpath("//span[text()='Buy']")).click();
		driver.findElement(By.xpath("//label[text()='Quantity']/following-sibling::input")).sendKeys("abc");	
			
		String quantity=driver.findElement(By.xpath("//label[text()='Quantity']/following-sibling::input")).getAttribute("value");
		assertEquals(quantity, "", "Quantity is not empty");			

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}

