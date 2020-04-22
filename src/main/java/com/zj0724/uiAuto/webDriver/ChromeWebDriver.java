package com.zj0724.uiAuto.webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class ChromeWebDriver extends BaseWebDriver {

    public ChromeWebDriver(String webDriverFilePath, boolean headless) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");

            // 系统类型
            String OsName = System.getProperty("os.name");
            // windows
            if (OsName.contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", webDriverFilePath);
                if (!headless) {
                    chromeOptions.addArguments("headless");
                }
            }
            // linux
            if (OsName.contains("Linux")) {
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("no-sandbox");
            }

            ChromeDriver webDriver = new ChromeDriver(chromeOptions);
            super.setWebDriver(webDriver);
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }
    }

    public ChromeWebDriver(File webDriverFile, boolean headless) {
        this(webDriverFile.getAbsolutePath(), false);
    }

    public ChromeWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

    public ChromeWebDriver(File webDriverFile) {
        this(webDriverFile.getAbsolutePath(), false);
    }

}
