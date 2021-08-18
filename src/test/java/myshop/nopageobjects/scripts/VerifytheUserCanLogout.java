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

public class VerifytheUserCanLogout {
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
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.xpath("//label[text()='User Name']/following-sibling::input")).sendKeys("admin");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		assertEquals(driver.getTitle(), "Home", "Page title is not Home");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
