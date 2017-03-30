package com.klindziuk.tabletest;

import java.util.concurrent.TimeUnit;
import com.klindziuk.driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.klindziuk.dbactions.OperationDropDB;
import com.klindziuk.dbactions.OperationCreateDB;

public class BaseTest {
    WebDriver driver = null;
    LoginPage loginPage;
    TablePage tablePage;

    @BeforeSuite
    public void suitSetup() {
        OperationCreateDB run = new OperationCreateDB();
        run.create();
    }

    @AfterSuite
    public void suitSetDown() {
        OperationDropDB drop = new OperationDropDB();
        drop.removeDB();
        drop.logOut();
        BrowserDriver.CHROME.killDriver();
    }

    @BeforeClass
    public void beforeTestClass() throws Exception {
        driver = BrowserDriver.CHROME.getDriver();
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