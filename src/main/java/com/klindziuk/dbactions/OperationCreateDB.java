package com.klindziuk.dbactions;

import java.util.concurrent.TimeUnit;

import com.klindziuk.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.klindziuk.tabletest.LoginPage;

public class OperationCreateDB {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(OperationCreateDB.class);

    public void create() {
        logger.info("Instantiating database creation.");
        try {
            driver = BrowserDriver.CHROME.getDriver();
            logger.info("Driver [" + driver.getClass().getSimpleName() + "] instantiated.");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(BrowserDriver.BASEURL);
            logger.info("Browser opened.Base page opened.");
            new LoginPage(driver).loginAs("root", "root");
            new OperationAddDB(driver).createDB();
            logger.info("Database added.");
            new OperationAddTable(driver).createTable();
            logger.info("Table added.");
            new OperationInsertData(driver).insertData();
            logger.info("Data inserted.");
            logger.info("Logging out.");
        } catch (Exception ex) {
            logger.error("ERROR! \n", ex);
        }
    }
}