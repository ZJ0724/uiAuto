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

    public ChromeWebDriver(File webDriverFile, boolean isShow) {
        super(getWebDriver(webDriverFile, isShow));
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

    private static WebDriver getWebDriver(File webDriverFile, boolean isShow) {
        if (webDriverFile == null) {
            throw new WebDriverException("文件不能为空");
        }

        // 返回的驱动程序
        WebDriver webDriver;
        // 谷歌设置
        ChromeOptions chromeOptions = new ChromeOptions();
        // 设置List
        List<String> options = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", webDriverFile.getAbsolutePath());

        // 设置浏览器最大化
        options.add("start-maximized");

        chromeOptions.setHeadless(!isShow);

        // linux系统设置沙盒模式
        if (Storage.SYSTEM_OS == SystemOS.LINUX) {
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