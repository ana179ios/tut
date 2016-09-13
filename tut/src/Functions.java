package src;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import java.awt.AWTException;

import src.Locators;
import src.Parameters;

public class Functions {

	public static void log_inside(WebDriver driver) {

		Verify.wait(driver);
		WebElement login = driver.findElement(Locators.fieldForLogin);
		login.clear();
		login.sendKeys(Parameters.loginForMail);
		WebElement password = driver.findElement(Locators.fieldForPassword);
		password.clear();
		password.sendKeys(Parameters.passwordForMail);
		driver.findElement(Locators.enterButton).click();
	}
	public static void log_insider(WebDriver driver, String logIn,
			String passwOrd) {
		Verify.wait(driver);	
		WebElement log = driver.findElement(Locators.fieldForLogin);
		log.clear();
		log.sendKeys(logIn);
		WebElement pass = driver.findElement(Locators.fieldForPassword);
		pass.clear();
		pass.sendKeys(passwOrd);
		driver.findElement(Locators.enterButton).click();
	}
	public static void checkSentMails(WebDriver driver) {

		Verify.wait(driver);
		driver.findElement(By.linkText("Отправленные")).click();
/*
		WebElement roleSelect = driver.findElement(By
				.xpath("//div/div[2]/div[2]/div/div/div[1]/div[1]"));
		Select select = new Select(roleSelect);// переопределяю
		select.deselectByVisibleText("Входящие"); // убираю элемент по видимому
													// тексту
		select.selectByVisibleText("Отправленные"); // выбираю элемент по
														// видимому тексту
		((WebElement) select).click();
*/
		Verify.wait(driver);
		driver.findElement(Locators.switchSentMails).click();
		Verify.wait(driver);
	}
	public static int numberOfMails(WebDriver driver) {
		int b;
		int kol = driver.findElements(By.xpath("//label[@class=\"b-messages__message__checkbox\"]"))
				.size();
		b=kol-1;
		System.out.println("Количество отправленных писем равно  "+ b);
		return kol;
	}
	public static void logOut(WebDriver driver) {	
		Verify.wait(driver);
		driver.findElement(Locators.buttonAva1).click();
		Verify.wait(driver);
		driver.findElement(Locators.buttonLogOut).click();
	}
}