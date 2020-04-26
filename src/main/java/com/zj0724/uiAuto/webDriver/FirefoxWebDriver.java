package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.config.ProjectConfig;
import com.zj0724.uiAuto.constant.SystemType;
import com.zj0724.uiAuto.constant.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;

public class FirefoxWebDriver extends BaseWebDriver {

    /**
     * 构造函数
     * */
    public FirefoxWebDriver(boolean headless) {
        this.loadWebDriver(headless);
    }
    public FirefoxWebDriver() {
        this.loadWebDriver(true);
    }
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

            // linux
            if (ProjectConfig.SYSTEM_TYPE == SystemType.LINUX) {
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
        WebDriver webDriver;
        if (ProjectConfig.SYSTEM_TYPE == SystemType.WINDOWS) {
            webDriver = WebDriver.WINDOWS_CHROME_WEB_DRIVER;
        } else if (ProjectConfig.SYSTEM_TYPE == SystemType.LINUX) {
            webDriver = WebDriver.LINUX_CHROME_WEB_DRIVER;
        } else {
            throw ErrorException.bug("系统类型未找到");
        }

        super.createWebDriverFile(webDriver);
        this.loadWebDriver(webDriver.getWebDriverFile(), headless);
    }

}
