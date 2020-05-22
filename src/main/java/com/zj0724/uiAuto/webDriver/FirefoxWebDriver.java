package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.config.ProjectConfig;
import com.zj0724.uiAuto.config.SystemOSConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;

public class FirefoxWebDriver extends BaseWebDriver {

    /**
     * 构造函数
     * */
    public FirefoxWebDriver(File webDriverFile, boolean headless) {
        super(webDriverFile, headless);
    }
    public FirefoxWebDriver(File webDriverFile) {
        this(webDriverFile, true);
    }
    public FirefoxWebDriver(String webDriverFilePath, boolean headless) {
        this(new File(webDriverFilePath), headless);
    }
    public FirefoxWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, true);
    }

    @Override
    protected WebDriver loadWebDriver() {
        // 返回的驱动
        WebDriver result = null;

        System.setProperty("webdriver.gecko.driver", webDriverFile.getAbsolutePath());
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        // windows设置headless
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.WINDOWS) {
            firefoxOptions.setHeadless(headless);
        }

        // linux默认设置headless为true，并开启沙盒
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.LINUX) {
            firefoxOptions.setHeadless(true);
            firefoxOptions.addArguments("--no-sandbox");
        }

        // 实例化驱动
        try {
            result = new FirefoxDriver(firefoxOptions);
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }

        return result;
    }

}
