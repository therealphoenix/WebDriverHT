package com.klindziuk.dboperations;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperationAddTable {
    private WebDriver driver;
    private By tableLocator = By.name("table");
    private By buttonSubmitLocator = By.xpath("//input[@type='submit']");
    private By additionalFieldsLocator = By.name("added_fields");
    private By buttonSubmitAdditionalFieldsLocator = By.name("submit_num_fields");
    private By firstColumnLocator = By.name("field_name[0]");
    private By secondColumnLocator = By.name("field_name[1]");
    private By thirdColumnLocator = By.name("field_name[2]");
    private By fourthColumnLocator = By.name("field_name[3]");
    private By fifthColumnLocator = By.name("field_name[4]");
    private By sixthColumnLocator = By.name("field_name[5]");
    private By idTypeLocator = By.xpath("//select[@id = 'field_0_2']//*[text() = 'INT']");
    private By loginTypeLocator = By.xpath("//select[@id = 'field_1_2']//*[text() = 'VARCHAR']");
    private By passwordTypeLocator = By.xpath("//select[@id = 'field_2_2']//*[text() = 'CHAR']");
    private By emailTypeLocator = By.xpath("//select[@id = 'field_3_2']//*[text() = 'VARCHAR']");
    private By nameTypeLocator = By.xpath("//select[@id = 'field_4_2']//*[text() = 'VARCHAR']");
    private By rememberTypeLocator = By.xpath("//select[@id = 'field_5_2']//*[text() = 'CHAR']");
    private By lengthIdLocator = By.id("field_0_3");
    private By lengthLoginLocator = By.id("field_1_3");
    private By lengthPasswordLocator = By.id("field_2_3");
    private By lengthEmailLocator = By.id("field_3_3");
    private By lengthNameLocator = By.id("field_4_3");
    private By lengthRememberLocator = By.id("field_5_3");
    private By primaryKeyLocator = By.xpath("//select[@id = 'field_0_7']//*[text() = 'PRIMARY']");
    private By popUpWindowButtonLocator = By.cssSelector("button.ui-button:nth-child(1)");
    private By autoIncrementLocator = By.xpath("//input[@name='field_extra[0]']");
    private By collationLocator = By.xpath("//select[@name = 'tbl_collation']//*[text() = 'utf8_general_ci']");
    private By submitCreationLocator = By.xpath("//input[@name='do_save_data']");
    private By iconStructureLocator = By.cssSelector(".ic_normalize");
    private By exceptionLocator = By.cssSelector("div.print_ignore:nth-child(4) > label:nth-child(3)");

    public OperationAddTable(WebDriver driver) {
        this.driver = driver;
    }

    public void addTable(String name) {
        WebElement tableElement = driver.findElement(tableLocator);
        tableElement.clear();
        tableElement.sendKeys(name);
        driver.findElement(buttonSubmitLocator).click();
    }

    public void addColumns(String columns) {
        WebElement additionalFieldsElement = driver.findElement(additionalFieldsLocator);
        additionalFieldsElement.clear();
        additionalFieldsElement.sendKeys(columns);
        driver.findElement(buttonSubmitAdditionalFieldsLocator).click();
    }

    public void waitForAdditionalComumns() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lengthRememberLocator));
    }

    public void waitForStructure() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(iconStructureLocator));
        } catch (TimeoutException toex) {
            WebDriverWait wait1 = new WebDriverWait(driver, 5);
            wait1.until(ExpectedConditions.visibilityOfElementLocated(exceptionLocator));
        }
    }

    public void addNamesOfColumn(String id, String login, String password, String email, String name, String remember) {
        driver.findElement(firstColumnLocator).sendKeys(id);
        driver.findElement(secondColumnLocator).sendKeys(login);
        driver.findElement(thirdColumnLocator).sendKeys(password);
        driver.findElement(fourthColumnLocator).sendKeys(email);
        driver.findElement(fifthColumnLocator).sendKeys(name);
        driver.findElement(sixthColumnLocator).sendKeys(remember);
    }

    public void selectTypes() {
        driver.findElement(idTypeLocator).click();
        driver.findElement(loginTypeLocator).click();
        driver.findElement(passwordTypeLocator).click();
        driver.findElement(emailTypeLocator).click();
        driver.findElement(nameTypeLocator).click();
        driver.findElement(rememberTypeLocator).click();
    }

    public void setLengthOfValues(String idLength, String loginLength, String passwordLength,
                                  String emailLength, String nameLength, String rememberLength) {
        driver.findElement(lengthIdLocator).sendKeys(idLength);
        driver.findElement(lengthLoginLocator).sendKeys(loginLength);
        driver.findElement(lengthPasswordLocator).sendKeys(passwordLength);
        driver.findElement(lengthEmailLocator).sendKeys(emailLength);
        driver.findElement(lengthNameLocator).sendKeys(nameLength);
        driver.findElement(lengthRememberLocator).sendKeys(rememberLength);
    }

    public void setPrimaryKey() {
        driver.findElement(primaryKeyLocator).click();
        // close pop up window
        driver.findElement(popUpWindowButtonLocator).click();
    }

    public void setAutoIncrement() {
        driver.findElement(autoIncrementLocator).click();
    }

    public void selectTableCollation() {
        driver.findElement(collationLocator).click();
    }

    public void submitCreatingTable() {
        //scroll down page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(submitCreationLocator).click();
    }

    public void createTable() {
        addTable("users");
        addColumns("2");
        waitForAdditionalComumns();
        addNamesOfColumn("u_id", "u_login", "u_password", "u_email", "u_name", "u_remember");
        selectTypes();
        setLengthOfValues("11","255","40","255","255","40");
        setPrimaryKey();
        setAutoIncrement();
        selectTableCollation();
        submitCreatingTable();
        waitForStructure();
    }
}