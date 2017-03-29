package com.klindziuk.testtable;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DataTableTest {

	String baseURL = "http://localhost/phpmyadmin/";
	// WHY WE SHOULD INITIALIZE IT HERE, if NOT INITIALIZE - aftersuit will crash (
	WebDriver driver = null;
	LoginPage loginPage;
	TablePage tablePage;

	@BeforeClass
	public void beforeTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Java/Chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		loginPage = new LoginPage(driver);
		loginPage.loginAs("root", "root");
		tablePage = new TablePage(driver);
		tablePage.selectDatabase();
		tablePage.selectTable();
	}

	@AfterClass
	public void afterTest() {
		tablePage.logOut();
	}

	@Test
	public void testData_User1() {
		// check for right page is opened
		Assert.assertTrue("localhost / localhost / auth | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check u_id
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user1IdLocator, "1"));
		// check u_login
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user1LoginLocator, "user1"));
		// check u_password
		Assert.assertTrue(
				tablePage.checkWebElement(tablePage.user1PasswordLocator, "e38ad214943daad1d64c102faec29de4afe9da3d"));
		// check u_email
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user1EmailLocator, "user1@mail.com"));
		// check u_name
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user1NameLocator, "Pupkin"));
		// check u_remember
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user1RememberLocator, ""));
	}

	@Test
	public void testData_User2() {
		// check for right page is opened
		Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check u_id
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2IdLocator, "2"));
		// check u_login
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2LoginLocator, "user2"));
		// check u_password
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2PasswordLocator, "2aa60a8ff7fcd473d321e0146afd9e26df395147"));
		// check u_email
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2EmailLocator, "user2@mail.com"));
		// check u_name
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2NameLocator, "Smith"));
		// check u_remember
		Assert.assertTrue(tablePage.checkWebElement(tablePage.user2RememberLocator, ""));
	}
}