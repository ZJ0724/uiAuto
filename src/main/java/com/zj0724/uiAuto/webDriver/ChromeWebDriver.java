package com.zj0724.uiAuto.webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class ChromeWebDriver extends BaseWebDriver {

    public ChromeWebDriver(String webDriverFilePath, boolean headless) {
        try {
            System.setProperty("webdriver.chrome.driver", webDriverFilePath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.setHeadless(headless);

            // 系统类型
            String OsName = System.getProperty("os.name");
            // linux
            if (OsName.contains("Linux")) {
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("no-sandbox");
            }

            super.setWebDriver(new ChromeDriver(chromeOptions));
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }
    }

    public ChromeWebDriver(File webDriverFile, boolean headless) {
        this(webDriverFile.getAbsolutePath(), headless);
    }

    public ChromeWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, true);
    }

    public ChromeWebDriver(File webDriverFile) {
        this(webDriverFile.getAbsolutePath(), true);
    }

}
