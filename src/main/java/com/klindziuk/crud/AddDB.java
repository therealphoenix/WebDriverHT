package com.klindziuk.crud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddDB {
    private WebDriver driver;
    private By newDBLocator = By.linkText("New");
    private By dbNameLocator = By.id("text_create_db");
    private By buttonGoLocator = By.id("buttonGo");
    private By dbCollationLocator = By.cssSelector("#create_database_form > select:nth-child(6)");
    private By utf8generalLocator = By.cssSelector("#create_database_form > select:nth-child(6) > optgroup:nth-child(42) > option:nth-child(7)");

    public AddDB(WebDriver driver) {
        this.driver = driver;
    }

    public void createDB() {
        driver.findElement(newDBLocator).click();
        driver.findElement(dbNameLocator).clear();
        driver.findElement(dbNameLocator).sendKeys("auth");
        driver.findElement(dbCollationLocator).click();
        driver.findElement(utf8generalLocator).click();
        driver.findElement(buttonGoLocator).click();
    }
}