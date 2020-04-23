package com.zj0724.uiAuto.webDriver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;

public class FirefoxWebDriver extends BaseWebDriver {

    /**
     * 构造函数
     * */
    public FirefoxWebDriver(File webDriverFile, boolean headless) {
        this.loadWebDriver(webDriverFile, headless);
    }
    public FirefoxWebDriver(File webDriverFile) {
        this.loadWebDriver(webDriverFile, true);
    }
    public FirefoxWebDriver(String webDriverFilePath, boolean headless) {
        this.loadWebDriver(new File(webDriverFilePath), headless);
    }
    public FirefoxWebDriver(String webDriverFilePath) {
        this.loadWebDriver(new File(webDriverFilePath), true);
    }

    @Override
    protected void loadWebDriver(File webDriverFile, boolean headless) {
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

    @Override
    protected void loadWebDriver(boolean headless) {

    }

}
