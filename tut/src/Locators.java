package src;

import org.openqa.selenium.By;

public class Locators {

	public static By fieldForLogin=By.name("login");
	public static By fieldForPassword=By.name("password");
	public static By enterButton=By.xpath("//input[@value='Войти']");	
	public static By sentMails=By.xpath("(//a[@href=\"#sent\"])");
	public static By switchSentMails=By.xpath("//div/div[1]/div[2]/div/label/input");

	public static By buttonAva1=By.xpath(".//*[@id='nb-1']/span[2]");
	public static By buttonLogOut=By.xpath("(//a[contains(text(),\"Выход\")])[2]");
}
