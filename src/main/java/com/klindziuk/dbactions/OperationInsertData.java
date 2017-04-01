package com.klindziuk.dbactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationInsertData {
    private WebDriver driver;
    private By insertMenuLocator = By.xpath("//*[@title='Insert']");
    private By logOffButtonLocator = By.cssSelector(".ic_s_loggoff");
    private By buttonYesLocator = By.cssSelector("#buttonYes");
    private By user1IdFormLocator = By.cssSelector("#field_1_3");
    private By user1LoginFormLocator = By.cssSelector("#field_2_3");
    private By user1PasswordFormLocator = By.cssSelector("#field_3_3");
    private By user1EmailFormLocator = By.cssSelector("#field_4_3");
    private By user1NameFormLocator = By.cssSelector("#field_5_3");
    private By user1RememberFormLocator = By.cssSelector("#field_6_3");
    private By user2IdFormLocator = By.cssSelector("#field_7_3");
    private By user2LoginFormLocator = By.cssSelector("#field_8_3");
    private By user2PasswordFormLocator = By.cssSelector("#field_9_3");
    private By user2EmailFormLocator = By.cssSelector("#field_10_3");
    private By user2NameFormLocator = By.cssSelector("#field_11_3");
    private By user2RememberFormLocator = By.cssSelector("#field_12_3");
    private By selectLocator = By.id("select");


    public OperationInsertData(WebDriver driver) {
        this.driver = driver;
    }

    public void openInsertMenu() {
        driver.findElement(insertMenuLocator).click();
    }

    public void fillDataUser1(String id, String login, String password, String email, String name, String remember) {
        driver.findElement(user1IdFormLocator).sendKeys(id);
        driver.findElement(user1LoginFormLocator).sendKeys(login);
        driver.findElement(user1PasswordFormLocator).sendKeys(password);
        driver.findElement(user1EmailFormLocator).sendKeys(email);
        driver.findElement(user1NameFormLocator).sendKeys(name);
        driver.findElement(user1RememberFormLocator).sendKeys(remember);
    }

    public void fillDataUser2(String id, String login, String password, String email, String name, String remember) {
        driver.findElement(user2IdFormLocator).sendKeys(id);
        driver.findElement(user2LoginFormLocator).sendKeys(login);
        driver.findElement(user2PasswordFormLocator).sendKeys(password);
        driver.findElement(user2EmailFormLocator).sendKeys(email);
        driver.findElement(user2NameFormLocator).sendKeys(name);
        driver.findElement(user2RememberFormLocator).sendKeys(remember);
    }

    public void pushButton() {
        driver.findElement(buttonYesLocator).click();
    }

    public void logOut() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectLocator));
        driver.findElement(logOffButtonLocator).click();
        driver.close();
    }

    public void insertData() {
        openInsertMenu();
        fillDataUser1("1", "user1", "e38ad214943daad1d64c102faec29de4afe9da3d", "user1@mail.com", "Pupkin", "");
        fillDataUser2("2", "user2", "2aa60a8ff7fcd473d321e0146afd9e26df395147", "user2@mail.com", "Smith", "" );
        pushButton();
        logOut();
    }
}
