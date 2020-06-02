package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.config.ProjectConfig;
import com.zj0724.uiAuto.config.SystemOSConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChromeWebDriver extends BaseWebDriver {

    /***
     * 构造方法
     */
    public ChromeWebDriver(File webDriverFile, boolean headless) {
        super(webDriverFile, headless);
    }
    public ChromeWebDriver(File webDriverFile) {
        this(webDriverFile, true);
    }
    public ChromeWebDriver(String webDriverFilePath, boolean headless) {
        this(new File(webDriverFilePath), headless);
    }
    public ChromeWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, true);
    }

    @Override
    protected WebDriver loadWebDriver() {
        // 返回的驱动程序
        WebDriver webDriver = null;
        // 谷歌设置
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置List
        List<String> options = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", this.webDriverFile.getAbsolutePath());

        // 设置浏览器最大化
        options.add("start-maximized");

        // windows系统设置headless
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.WINDOWS) {
            chromeOptions.setHeadless(this.headless);
        }

        // linux系统默认设置headless为true，并设置沙盒模式
        if (ProjectConfig.SYSTEM_TYPE == SystemOSConfig.LINUX) {
            chromeOptions.setHeadless(true);
            options.add("no-sandbox");
        }

        chromeOptions.addArguments(options);

        // 实例化驱动
        try {
            webDriver = new ChromeDriver(chromeOptions);
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.uiAuto.exception.WebDriverException.driverFileError();
        }

        return webDriver;
    }

}