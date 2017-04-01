package com.klindziuk.tabletest;

import java.util.concurrent.TimeUnit;
import com.klindziuk.driver.BrowserDriver;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.klindziuk.dbactions.OperationDropDB;
import com.klindziuk.dbactions.OperationCreateDB;

import static com.klindziuk.driver.BrowserDriver.CHROME;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    TablePage tablePage;

    @BeforeSuite
    public void suitSetup() {
        driver = BrowserDriver.getDriver();
        PropertyConfigurator.configure("Log4j.properties");
        OperationCreateDB run = new OperationCreateDB(driver);
        run.create();
    }

    @AfterSuite
    public void suitSetDown() {
        driver = BrowserDriver.getDriver();
        OperationDropDB drop = new OperationDropDB(driver);
        drop.removeDB();
        drop.logOut();
        CHROME.killDriver();
    }

    @BeforeClass
    public void beforeTestClass() throws Exception {
        driver = BrowserDriver.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BrowserDriver.BASEURL);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("root", "root");
        tablePage = new TablePage(driver);
        tablePage.selectDatabase();
        tablePage.selectTable();
    }

    @AfterClass
    public void afterTestClass() {
        tablePage.logOut();
    }
}