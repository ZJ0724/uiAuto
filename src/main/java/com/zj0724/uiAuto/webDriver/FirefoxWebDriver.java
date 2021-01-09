package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.Storage;
import com.zj0724.uiAuto.SystemOS;
import com.zj0724.uiAuto.exception.WebDriverException;
import org.openqa.selenium.WebDriver;
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
public final class FirefoxWebDriver extends AbstractWebDriver {

    /**
     * 构造函数
     *
     * @param webDriverFile 驱动文件
     * @param isShow 是否显示浏览器
     * */
    public FirefoxWebDriver(File webDriverFile, boolean isShow) {
        super(webDriverFile, isShow);
    }

    public FirefoxWebDriver(File webDriverFile) {
        this(webDriverFile, false);
    }

    public FirefoxWebDriver(String webDriverFilePath, boolean isShow) {
        this(new File(webDriverFilePath), isShow);
    }

    public FirefoxWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

    @Override
    protected WebDriver loadWebDriver() {
        // 返回的驱动
        WebDriver result;
        // 火狐设置
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        // 火狐设置List
        List<String> options = new ArrayList<>();

        System.setProperty("webdriver.gecko.driver", webDriverFile.getAbsolutePath());

        // windows设置headless
        if (Storage.SYSTEM_OS == SystemOS.WINDOWS) {
            firefoxOptions.setHeadless(!isShow);
        }

        // linux默认设置headless为true，并开启沙盒
        if (Storage.SYSTEM_OS == SystemOS.LINUX) {
            firefoxOptions.setHeadless(true);
            options.add("--no-sandbox");
        }

        firefoxOptions.addArguments(options);

        // 实例化驱动
        try {
            result = new FirefoxDriver(firefoxOptions);
        } catch (Exception e) {
            throw new WebDriverException(e.getMessage());
        }

        return result;
    }

}