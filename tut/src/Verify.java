package src;

import static org.testng.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import src.Parameters;

public class Verify {
	public static void checkLogin(WebDriver driver, String loginName) {
		String admin = driver.findElement(
				By.xpath("//input[@id='Username']"))
				.getText();
		assertEquals(admin, Parameters.loginForMail);// assert не работает со
												// страницей, поэтому
												// switchTo().defaultContent()
												// можно и перед и после него
		driver.switchTo().defaultContent();
	}

	public static void checkSentMails(WebDriver driver) {
		assertTrue(driver.findElement(Locators.switchSentMails)
				.isSelected());
	}


	public static void wait(WebDriver driver) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
