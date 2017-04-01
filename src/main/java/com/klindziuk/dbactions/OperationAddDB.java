package com.klindziuk.dbactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OperationAddDB {
    private WebDriver driver;
    private final String DBNAME = "auth";
    private By newDBLocator = By.linkText("New");
    private By dbNameInputLocator = By.id("text_create_db");
    private By buttonGoLocator = By.id("buttonGo");
    private By exisTingdataBaseLocator = By.linkText("auth");
    private By dbCollationLocator = By.cssSelector("#create_database_form > select:nth-child(6)");
    private By utf8generalLocator = By.cssSelector("#create_database_form > select:nth-child(6) > optgroup:nth-child(42) > option:nth-child(7)");
    private final static Logger LOGGER = Logger.getLogger(OperationAddDB.class);

    public OperationAddDB(WebDriver driver) {
        this.driver = driver;
    }

    public void createDB() {
        driver.findElement(newDBLocator).click();
        if (checkForExistingDB()) {
            WebElement dbNameElement = driver.findElement(dbNameInputLocator);
            dbNameElement.clear();
            dbNameElement.sendKeys(DBNAME);
            driver.findElement(dbCollationLocator).click();
            driver.findElement(utf8generalLocator).click();
            driver.findElement(buttonGoLocator).click();
        } else {
            LOGGER.info("Can't create database.");
            LOGGER.info("Tests failed.");
            driver.close();
            driver.quit();
            System.exit(-1);
        }
    }

    private boolean checkForExistingDB() {
        LOGGER.info("Checking for existing database...");
        // wait for database list loading
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dbNameInputLocator));
        //checking for existing database
        WebElement db = null;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
             db = (new WebDriverWait(driver, 1))
                    .until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver d) {
                            return d.findElement(exisTingdataBaseLocator);
                        }
                    });
        } catch (TimeoutException tmex) {
            LOGGER.info("Everything OK.Can create Database");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return (db == null);
    }
}