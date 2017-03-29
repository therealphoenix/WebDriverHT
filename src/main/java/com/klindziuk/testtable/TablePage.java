package com.klindziuk.testtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePage {
    private WebDriver driver;
    private By dataBaseLocator = By.cssSelector("li.database:nth-child(2) > a:nth-child(3)");
    private By tableLocator = By.cssSelector("#row_tbl_1 > th:nth-child(2) > a:nth-child(1)");
    private By structureLocator = By.cssSelector("img.icon:nth-child(6)");
    private By logOutLocator = By.cssSelector(".ic_s_loggoff");
    private By columnLocator = By.cssSelector(".table > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > i:nth-child(2) > a:nth-child(2)");
    public By user1IdLocator = By.cssSelector(".odd > td:nth-child(5) > span:nth-child(1)");
    public By user1LoginLocator = By.cssSelector(".odd > td:nth-child(6) > span:nth-child(1)");
    public By user1PasswordLocator = By.cssSelector(".odd > td:nth-child(7) > span:nth-child(1)");
    public By user1EmailLocator = By.cssSelector(".odd > td:nth-child(8) > span:nth-child(1)");
    public By user1NameLocator = By.cssSelector(".odd > td:nth-child(9) > span:nth-child(1)");
    public By user1RememberLocator = By.cssSelector(".odd > td:nth-child(10)");
    public By user2IdLocator = By.cssSelector(".even > td:nth-child(5) > span:nth-child(1)");
    public By user2LoginLocator = By.cssSelector(".even > td:nth-child(6) > span:nth-child(1)");
    public By user2PasswordLocator = By.cssSelector(".even > td:nth-child(7) > span:nth-child(1)");
    public By user2EmailLocator = By.cssSelector(".even > td:nth-child(8) > span:nth-child(1)");
    public By user2NameLocator = By.cssSelector(".even > td:nth-child(9) > span:nth-child(1)");
    public By user2RememberLocator = By.cssSelector(".even > td:nth-child(10)");
    public By idNameLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(3) > label:nth-child(1)");
    public By idTypeLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4) > bdo:nth-child(1)");
    public By idNotNullLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7)");
    public By idAutoIncrementLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(9)");
    public By loginNameLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > label:nth-child(1)");
    public By loginTypeLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(4) > bdo:nth-child(1)");
    public By loginNotNullLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(7)");
    public By passwordNameLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > th:nth-child(3) > label:nth-child(1)");
    public By passwordTypeLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(4) > bdo:nth-child(1)");
    public By passwordNotNullLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(7)");
    public By emailNameLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > th:nth-child(3) > label:nth-child(1)");
    public By emailTypeLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(4) > bdo:nth-child(1)");
    public By emailNotNullLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)");
    public By nameNameLocator = By.cssSelector("tr.odd:nth-child(5) > th:nth-child(3) > label:nth-child(1)");
    public By nameTypeLocator = By.cssSelector("tr.odd:nth-child(5) > td:nth-child(4) > bdo:nth-child(1)");
    public By nameNotNullLocator = By.cssSelector("#tablestructure > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(7)");
    public By rememberNameLocator = By.cssSelector("tr.even:nth-child(6) > th:nth-child(3) > label:nth-child(1)");
    public By rememberTypeLocator = By.cssSelector("tr.even:nth-child(6) > td:nth-child(4) > bdo:nth-child(1)");
    public By rememberNotNullLocator = By.cssSelector("tr.even:nth-child(6) > td:nth-child(7)");
    public By collationLocator = By.cssSelector("#tablerowstats > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > dfn:nth-child(1)");
    public By autoIncrementLocator = By.cssSelector("#tablerowstats > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)");


    public TablePage(WebDriver driver) {
        this.driver = driver;
        this.driver = driver;
        // Checking for right page is opened
        if ((!driver.getTitle().equals("localhost / localhost | phpMyAdmin 4.5.1"))) {
            throw new IllegalStateException("Invalid page opened");
        }
    }

    // open database
    public void selectDatabase() {
        driver.findElement(dataBaseLocator).click();
    }

    // open table
    public void selectTable() {
        driver.findElement(tableLocator).click();
    }

    // open structure
    public void selectStructure() {
        driver.findElement(structureLocator).click();
    }

    // open columns
    public void selectColumns() {
        driver.findElement(columnLocator).click();
    }

    public boolean checkWebElement(By selector, String type) {
        WebElement element = driver.findElement(selector);
        return element.getText().equals(type);
    }

    public void logOut() {
        driver.findElement(logOutLocator).click();
        driver.close();
    }
}