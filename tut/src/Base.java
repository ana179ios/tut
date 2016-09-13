package src;

import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import src.Locators;
import src.Parameters;

public class Base {
	public static WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void beforeTest() {
		driver.get(Parameters.baseUrl);// запускает url
	}

	@AfterMethod
	public void afterTest() {
		driver.switchTo().defaultContent();
		try {
			driver.findElement(Locators.buttonLogOut).click();
		} catch (Exception e) {
			Reporter.log(e.toString());
		}
	}

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// время неявного ожидания															
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();

	}
}


