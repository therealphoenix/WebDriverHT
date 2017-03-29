package com.klindziuk.testtable;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.klindziuk.crud.DropDB;
import com.klindziuk.crud.CreateDB;

public class TableTest {
	String baseURL = "http://localhost/phpmyadmin/";
	WebDriver driver = null;
	LoginPage loginPage;
	TablePage tablePage;
	
	@BeforeSuite
	public void suitSetup() {
		CreateDB run = new CreateDB();
		run.create();
	}
	@AfterSuite
	public void suitSetDown() {
		DropDB drop = new DropDB();
		drop.removeDB();
		drop.logOut();
			}

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
		tablePage.selectStructure();
		tablePage.selectColumns();
	}

	@AfterClass
	public void afterTest() {
		tablePage.logOut();
	}

	@Test
	public void testTable() {
		Assert.assertTrue("localhost / localhost / auth / users | phpMyAdmin 4.5.1".equals(driver.getTitle()));
		// check id field+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.idNameLocator, "u_id"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.idTypeLocator, "int(11)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.idNotNullLocator, "No"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.idAutoIncrementLocator, "AUTO_INCREMENT"));
		// check login+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.loginNameLocator, "u_login"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.loginTypeLocator, "varchar(255)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.loginNotNullLocator, "No"));
		// check password+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.passwordNameLocator, "u_password"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.passwordTypeLocator, "char(40)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.passwordNotNullLocator, "No"));
		// check email+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.emailNameLocator, "u_email"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.emailTypeLocator, "varchar(255)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.emailNotNullLocator, "No"));
		// check name+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.nameNameLocator, "u_name"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.nameTypeLocator, "varchar(255)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.nameNotNullLocator, "No"));
		// check remember+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.rememberNameLocator, "u_remember"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.rememberTypeLocator, "char(40)"));
		Assert.assertTrue(tablePage.checkWebElement(tablePage.rememberNotNullLocator, "No"));
		// check collation+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.collationLocator, "utf8_general_ci"));
		// check AutoIncrement+
		Assert.assertTrue(tablePage.checkWebElement(tablePage.autoIncrementLocator, "3"));
		
	}
}