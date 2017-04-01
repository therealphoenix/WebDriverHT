package com.klindziuk.driver;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {
    private static SingletonDriver instance;
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private SingletonDriver () {
        driver = BrowserDriver.CHROME.selectDriver();
    }

    public static SingletonDriver getInstance() {
        if (instance == null) {
            instance = new SingletonDriver();        }
        return instance;
    }
}
