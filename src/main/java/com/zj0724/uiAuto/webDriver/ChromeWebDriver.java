package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.Storage;
import com.zj0724.uiAuto.SystemOS;
import com.zj0724.uiAuto.exception.WebDriverException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 谷歌驱动
 *
 * @author ZJ
 * */
public final class ChromeWebDriver extends AbstractWebDriver {

    /***
     * 构造方法
     *
     * @param webDriverFile 驱动文件
     * @param isShow 是否显示浏览器
     */
    public ChromeWebDriver(File webDriverFile, boolean isShow) {
        super(webDriverFile, isShow);
    }

    public ChromeWebDriver(File webDriverFile) {
        this(webDriverFile, false);
    }

    public ChromeWebDriver(String webDriverFilePath, boolean isShow) {
        this(new File(webDriverFilePath), isShow);
    }

    public ChromeWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

    @Override
    protected WebDriver loadWebDriver() {
        // 返回的驱动程序
        WebDriver webDriver;
        // 谷歌设置
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置List
        List<String> options = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", this.webDriverFile.getAbsolutePath());

        // 设置浏览器最大化
        options.add("start-maximized");

        // windows系统设置headless
        if (Storage.SYSTEM_OS == SystemOS.WINDOWS) {
            chromeOptions.setHeadless(!this.isShow);
        }

        // linux系统默认设置headless为true，并设置沙盒模式
        if (Storage.SYSTEM_OS == SystemOS.LINUX) {
            chromeOptions.setHeadless(true);
            options.add("no-sandbox");
        }

        chromeOptions.addArguments(options);

        // 实例化驱动
        try {
            webDriver = new ChromeDriver(chromeOptions);
        } catch (Exception e) {
            throw new WebDriverException(e.getMessage());
        }

        return webDriver;
    }

}