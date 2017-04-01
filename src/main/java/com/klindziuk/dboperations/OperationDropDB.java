package com.klindziuk.dboperations;

import com.klindziuk.driver.BrowserDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.klindziuk.tabletest.LoginPage;

public class OperationDropDB {
    private WebDriver driver = null;
    private By newDBLocator = By.cssSelector("li.first > a:nth-child(3)");
    private By dbForRemoveLocator = By.xpath("//*[@title='auth']");
    private By submitButtonLocator = By.cssSelector(".mult_submit");
    private By popUpMenuButtonLocator = By.cssSelector(".submitOK");
    private By logOutLocator = By.cssSelector(".ic_s_loggoff");
    private final static Logger LOGGER = Logger.getLogger(OperationDropDB.class);

    public OperationDropDB(WebDriver driver) {
        this.driver = driver;
    }

    public void removeDB() {
        driver.get(BrowserDriver.BASEURL);
        LOGGER.info("Removing database...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("root", "root");
        driver.findElement(newDBLocator).click();
        driver.findElement(dbForRemoveLocator).click();
        //scrolling down page with databases
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(submitButtonLocator).click();
        driver.findElement(popUpMenuButtonLocator).click();
        LOGGER.info("Database removed successfully.");
    }

    public void logOut() {
        driver.findElement(logOutLocator).click();
        driver.quit();
        LOGGER.info("Logging out.");
    }
}