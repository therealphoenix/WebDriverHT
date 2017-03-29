package com.klindziuk.testtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By loginButtonLocator = By.xpath("//input[@type='submit']");
	By loginUserNameLocator = By.name("pma_username");
	By loginPasswordLocator = By.name("pma_password");
	By languageLocator = By.cssSelector("#sel-lang");
	By englishLanguageLocator = By.cssSelector("#sel-lang > option:nth-child(9)");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver = driver;
		// Checking for right page is opened
		if ((!driver.getTitle().equals("phpMyAdmin"))
				|| (!driver.getCurrentUrl().equals("http://localhost/phpmyadmin/"))) {
			throw new IllegalStateException("Invalid page opened");
		}
	}

	protected void pushLoginButton() {
		driver.findElement(loginButtonLocator).click();
	}

	protected void setUserName(String userName) {
		driver.findElement(loginUserNameLocator).clear();
		driver.findElement(loginUserNameLocator).sendKeys(userName);
	}

	protected void setPassword(String password) {
		driver.findElement(loginPasswordLocator).clear();
		driver.findElement(loginPasswordLocator).sendKeys(password);
	}
	public void setEnglish(){
		driver.findElement(languageLocator).click();
		driver.findElement(englishLanguageLocator).click();
	}

	public void loginAs(String userName, String password) {
		setEnglish();
		setUserName(userName);
		setPassword(password);
		pushLoginButton();
	}
}