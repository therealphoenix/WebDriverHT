package com.klindziuk.tabletest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
private	WebDriver driver;
private	By loginButtonLocator = By.xpath("//input[@type='submit']");
private	By loginUserNameLocator = By.name("pma_username");
private	By loginPasswordLocator = By.name("pma_password");
private	By englishLanguageLocator = By.xpath("//select[@id = 'sel-lang']//*[text() = 'English (United Kingdom)']");
private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
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
		WebElement loginElement = driver.findElement(loginUserNameLocator);
		loginElement.clear();
		loginElement.sendKeys(userName);
	}

	protected void setPassword(String password) {
		WebElement passwordElement = driver.findElement(loginPasswordLocator);
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void setEnglish() {
	driver.findElement(englishLanguageLocator).click();
		//wait for reloading page after select language
		(new WebDriverWait(driver,5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().equals("phpMyAdmin");
			}
		});
	}

	public void loginAs(String userName, String password) {
		LOGGER.info("Authorization started...");
		setEnglish();
		setUserName(userName);
		setPassword(password);
		pushLoginButton();
		LOGGER.info("Authorization completed successfully.");
	}
}