package com.klindziuk.dbactions;

import java.util.concurrent.TimeUnit;
import com.klindziuk.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.klindziuk.tabletest.LoginPage;

public class OperationCreateDB {
    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(OperationCreateDB.class);

    public void create() {
        LOGGER.info("Instantiating database creation.");
        try {
            driver = BrowserDriver.CHROME.getDriver();
            LOGGER.info("Driver [" + driver.getClass().getSimpleName() + "] instantiated.");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(BrowserDriver.BASEURL);
            LOGGER.info("Browser opened.Base page opened.");
            new LoginPage(driver).loginAs("root", "root");
            new OperationAddDB(driver).createDB();
            LOGGER.info("Database added.");
            new OperationAddTable(driver).createTable();
            LOGGER.info("Table added.");
            new OperationInsertData(driver).insertData();
            LOGGER.info("Data inserted.");
            LOGGER.info("Logging out.");
        } catch (Exception ex) {
            LOGGER.error("ERROR! \n", ex);
        }
    }
}