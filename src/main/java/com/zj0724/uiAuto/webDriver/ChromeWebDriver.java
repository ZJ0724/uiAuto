package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.config.ProjectConfig;
import com.zj0724.uiAuto.constant.SystemType;
import com.zj0724.uiAuto.constant.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class ChromeWebDriver extends BaseWebDriver {

    /***
     * 构造方法
     */
    public ChromeWebDriver(boolean headless) {
        this.loadWebDriver(headless);
    }
    public ChromeWebDriver() {
        this.loadWebDriver(true);
    }
    public ChromeWebDriver(String webDriverFilePath, boolean headless) {
        this.loadWebDriver(new File(webDriverFilePath), headless);
    }
    public ChromeWebDriver(File webDriverFile, boolean headless) {
        this.loadWebDriver(webDriverFile, headless);
    }
    public ChromeWebDriver(String webDriverFilePath) {
        this.loadWebDriver(new File(webDriverFilePath), true);
    }
    public ChromeWebDriver(File webDriverFile) {
        this.loadWebDriver(webDriverFile, true);
    }

    @Override
    protected void loadWebDriver(File webDriverFile, boolean headless) {
        try {
            System.setProperty("webdriver.chrome.driver", webDriverFile.getAbsolutePath());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.setHeadless(headless);

            // linux
            if (ProjectConfig.SYSTEM_TYPE == SystemType.LINUX) {
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("no-sandbox");
            }

            super.setWebDriver(new ChromeDriver(chromeOptions));
        } catch (IllegalStateException | WebDriverException e) {
            System.out.println(e.getMessage());
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }
    }

    @Override
    protected void loadWebDriver(boolean headless) {
        WebDriver webDriver;
        if (ProjectConfig.SYSTEM_TYPE == SystemType.WINDOWS) {
            webDriver = WebDriver.WINDOWS_CHROME_WEB_DRIVER;
        } else if (ProjectConfig.SYSTEM_TYPE == SystemType.LINUX) {
            webDriver = WebDriver.LINUX_CHROME_WEB_DRIVER;
        } else {
            throw ErrorException.bug("系统类型未找到");
        }

        super.createWebDriverFile(webDriver);
        System.out.println(webDriver.getWebDriverFile());
        this.loadWebDriver(webDriver.getWebDriverFile(), headless);
    }

}
