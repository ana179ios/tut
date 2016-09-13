package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import static org.testng.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import src.DataForTest;
import src.TestLogInLogOutParameter;
import src.Locators;
import src.Functions;
import src.Parameters;
import src.Verify;

public class Project extends Base {

	public void testLogInLogOut(TestLogInLogOutParameter parameterObject)
			throws Exception {

		Functions.log_insider(driver, parameterObject.logIn,
				parameterObject.passwOrd);
		switch (parameterObject.check) {
		case "1":
			Verify.checkLogin(driver, parameterObject.logIn);
			break;
		case "2":
			Alert a1 = driver.switchTo().alert();
			String s = a1.getText();
			a1.accept();
			assertEquals(s, "Your password has been emailed to you.");
			break;
		default:
			fail(parameterObject.check);
		}
	}


	@Test
	public void testMail() throws Exception {
		Functions.log_inside(driver);
		Functions.checkSentMails(driver);
		Functions.numberOfMails(driver);
		Verify.checkSentMails(driver);
		Functions.logOut(driver);
	}
}