package com.klindziuk.crud;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import com.klindziuk.testtable.LoginPage;

public class DropDB {
    private String baseURL = "http://localhost/phpmyadmin/";
    private WebDriver driver = null;
    private By newDBLocator = By.cssSelector("li.first > a:nth-child(3)");
    private By dbForRemoveLocator = By.cssSelector("tr.odd:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
    private By submitButtonLocator = By.cssSelector(".mult_submit");
    private By popUpMenuButtonLocator = By.cssSelector(".submitOK");
    private By logOutLocator = By.cssSelector(".ic_s_loggoff");

    public void removeDB() {
        System.setProperty("webdriver.chrome.driver", "D:/Java/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
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
        DropDB d = new DropDB();
        d.removeDB();
    }
}