package com.zj0724.uiauto.webDriver;

import com.zj0724.uiauto.config.ProjectConfig;
import com.zj0724.uiauto.config.SystemOSConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 火狐驱动
 *
 * @author ZJ
 * */
public final class FirefoxWebDriver extends BaseWebDriver {

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
        // 火狐设置
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        // 火狐设置List
        List<String> options = new ArrayList<>();

        System.setProperty("webdriver.gecko.driver", webDriverFile.getAbsolutePath());

        // windows设置headless
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.WINDOWS) {
            firefoxOptions.setHeadless(headless);
        }

        // linux默认设置headless为true，并开启沙盒
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.LINUX) {
            firefoxOptions.setHeadless(true);
            options.add("--no-sandbox");
        }

        firefoxOptions.addArguments(options);

        // 实例化驱动
        try {
            result = new FirefoxDriver(firefoxOptions);
        } catch (IllegalStateException | WebDriverException e) {
            throw WebDriverFileException.getInstance();
        }

        return result;
    }

}