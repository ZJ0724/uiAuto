package com.zj0724.uiAuto.webDriver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;

public class FirefoxWebDriver extends BaseWebDriver {

    public FirefoxWebDriver(File webDriverFile, boolean headless) {
        try {
            System.setProperty("webdriver.gecko.driver", webDriverFile.getAbsolutePath());
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(headless);

            // 系统类型
            String OsName = System.getProperty("os.name");
            // linux
            if (OsName.contains("Linux")) {
                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("--no-sandbox");
            }

            super.setWebDriver(new FirefoxDriver(firefoxOptions));
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }
    }

    public FirefoxWebDriver(File webDriverFile) {
        this(webDriverFile, true);
    }

    public FirefoxWebDriver(String webDriverFilePath, boolean headless) {
        this(new File(webDriverFilePath), headless);
    }

    public FirefoxWebDriver(String webDriverFilePath) {
        this(new File(webDriverFilePath), true);
    }

}
