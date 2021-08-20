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

public class VerifytheUserCannotSignupWithoutEnteringPassword {
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
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		
		driver.findElement(By.xpath("//label[text()='User Name']/following-sibling::input")).sendKeys("Admin");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("");
		driver.findElement(By.xpath("//label[text()='Re-Enter Password']/following-sibling::input")).sendKeys("123");
		driver.findElement(By.xpath("//input[@value='Register']")).click();		
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		assertEquals(alert.getText(), "Please enter a passwords to proceed", "Alert message was not - Please enter a passwords to proceed");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
