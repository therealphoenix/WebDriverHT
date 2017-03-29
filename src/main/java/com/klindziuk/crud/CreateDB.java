package com.klindziuk.crud;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.klindziuk.testtable.LoginPage;

public class CreateDB {
    private String baseURL = "http://localhost/phpmyadmin/";
    private WebDriver driver;
    private LoginPage loginPage;
    private AddDB addDB;
    private AddColumns columns;
    private InsertData insertData;

    public void create() {
        System.setProperty("webdriver.chrome.driver", "D:/Java/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("root", "root");
        addDB = new AddDB(driver);
        addDB.createDB();
        columns = new AddColumns(driver);
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
        insertData = new InsertData(driver);
        insertData.openInsertMenu();
        insertData.fillData();
        insertData.pushButton();
    //    insertData.moveToBrowse();
        insertData.logOut();
    }
}