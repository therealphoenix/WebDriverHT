package com.klindziuk.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public enum BrowserDriver {

    /**
     *  We can add here another browsers to run tests with them
     *  For Example:
     *  INTERNET EXPLORER(2)
     *  FIREFOX(3)
     *  OPERA(4)
     *  SAFARI(5)
     *  etc.
     *
     */
    CHROME(1);

    public static final String BASEURL = "http://localhost/phpmyadmin/";
    private int index;
    BrowserDriver(int browserIndex) {
        this.index = browserIndex;
    }

    public static  WebDriver getDriver() {
        return CHROME.selectDriver();
    }

    public  WebDriver selectDriver() {
        switch (index) {
            case 1: {
                System.setProperty("webdriver.chrome.driver", "D:/Java/Chrome/chromedriver.exe");
                return new ChromeDriver();
            }
            default: {
                System.setProperty("webdriver.chrome.driver", "D:/Java/Chrome/chromedriver.exe");
                return new ChromeDriver();
            }
        }
    }

    public void killDriver() {
        try {
            switch (index) {
                case 1: {
                    Runtime.getRuntime().exec("taskkill /f /IM chromedriver.exe");
                }
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}

