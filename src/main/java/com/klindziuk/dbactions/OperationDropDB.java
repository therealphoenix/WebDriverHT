package com.klindziuk.dbactions;

import java.util.concurrent.TimeUnit;

import com.klindziuk.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.klindziuk.tabletest.LoginPage;

public class OperationDropDB {
    private WebDriver driver = null;
    private By newDBLocator = By.cssSelector("li.first > a:nth-child(3)");
    private By dbForRemoveLocator = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
    private By submitButtonLocator = By.cssSelector(".mult_submit");
    private By popUpMenuButtonLocator = By.cssSelector(".submitOK");
    private By logOutLocator = By.cssSelector(".ic_s_loggoff");

    public void removeDB() {
        driver = BrowserDriver.CHROME.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BrowserDriver.BASEURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("root", "root");
        driver.findElement(newDBLocator).click();
        driver.findElement(dbForRemoveLocator).click();
        driver.findElement(submitButtonLocator).click();
        driver.findElement(popUpMenuButtonLocator).click();
    }
    public void logOut() {
        driver.findElement(logOutLocator).click();
        driver.close();
    }
    public static void main(String[] args) {
        OperationDropDB d = new OperationDropDB();
        d.removeDB();
    }
}