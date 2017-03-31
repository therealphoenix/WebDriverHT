package com.klindziuk.dbactions;

import java.util.concurrent.TimeUnit;
import com.klindziuk.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import com.klindziuk.tabletest.LoginPage;

public class OperationCreateDB {
    private WebDriver driver;
    private LoginPage loginPage;
    private OperationAddDB operationAddDB;
    private OperationAddColumns columns;
    private OperationInsertData operationInsertData;
    private static Logger logger = Logger.getLogger("OperationCreateDB");

     public void create() {
         logger.info("Instantiating database creation.");
         try {
             driver = BrowserDriver.CHROME.getDriver();
             logger.info("Driver [" + driver.getClass().getSimpleName() + "] instantiated.");
             driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             driver.manage().window().maximize();
             driver.get(BrowserDriver.BASEURL);
             logger.info("Browser opened.Base page opened.");
             loginPage = new LoginPage(driver);
             loginPage.loginAs("root", "root");
             operationAddDB = new OperationAddDB(driver);
             operationAddDB.createDB();
             logger.info("Database added.");
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
             logger.info("Table added.");
             operationInsertData = new OperationInsertData(driver);
             operationInsertData.openInsertMenu();
             operationInsertData.fillData();
             operationInsertData.pushButton();
             logger.info("Data inserted.");
             operationInsertData.logOut();
             logger.info("Logging out.");
         } catch (Exception ex) {
          logger.error("ERROR! \n",ex);
         }
     }
}