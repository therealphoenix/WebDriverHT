package com.klindziuk.dbactions;

import java.util.concurrent.TimeUnit;

import com.klindziuk.driver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.klindziuk.tabletest.LoginPage;

public class OperationCreateDB {
    private WebDriver driver;
    private LoginPage loginPage;
    private OperationAddDB operationAddDB;
    private OperationAddColumns columns;
    private OperationInsertData operationInsertData;

    public void create() {
        driver = BrowserDriver.CHROME.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BrowserDriver.BASEURL);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("root", "root");
        operationAddDB = new OperationAddDB(driver);
        operationAddDB.createDB();
        columns = new OperationAddColumns(driver);
        columns.addTable();
        columns.addColumns("2");
        columns.waitForAdditionalComumns();
        columns.addNamesOfColumn();
        columns.selectTypes();
        columns.setLengthOfValues();
        columns.setPrimaryKey();
        columns.setAutoIncrement();
        columns.selectTableCollation();
        columns.submitCreatingTable();
        columns.waitForStructure();
        operationInsertData = new OperationInsertData(driver);
        operationInsertData.openInsertMenu();
        operationInsertData.fillData();
        operationInsertData.pushButton();
        operationInsertData.logOut();
    }
}