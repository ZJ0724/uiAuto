package com.zj0724.StepWebDriver.common;

import com.zj0724.StepWebDriver.StepWebDriver;
import com.zj0724.StepWebDriver.proxy.AnnotationCheckProxy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeStepWebDriver implements StepWebDriver {

    private WebDriver webDriver;

    /**
     * 获取一个谷歌驱动
     * */
    public static StepWebDriver getChromeStepWebDriver(File webDriverFile, boolean headless) {
        return (StepWebDriver) AnnotationCheckProxy.getProxyObject(new ChromeStepWebDriver(webDriverFile, headless));
    }
    public static StepWebDriver getChromeStepWebDriver(String chromeDriverPath) {
        return getChromeStepWebDriver(new File(chromeDriverPath), false);
    }
    public static StepWebDriver getChromeStepWebDriver(String webDriverFilePath, boolean headless) {
        return getChromeStepWebDriver(new File(webDriverFilePath), false);
    }
    public static StepWebDriver getChromeStepWebDriver(File webDriverFile) {
        return getChromeStepWebDriver(webDriverFile, false);
    }

    /**
     * 构造方法
     * */
    private ChromeStepWebDriver(String webDriverFilePath, boolean headless) {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");

            // 系统类型
            String OsName = System.getProperty("os.name");
            // windows
            if (OsName.contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", webDriverFilePath);
                if (!headless) {
                    chromeOptions.addArguments("headless");
                }
            }
            // linux
            if (OsName.contains("Linux")) {
                chromeOptions.addArguments("headless");
                chromeOptions.addArguments("no-sandbox");
            }

            ChromeDriver webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.webDriver = webDriver;
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.StepWebDriver.exception.WebDriverException.driverFileError();
        }
    }
    private ChromeStepWebDriver(File webDriverFile, boolean headless) {
        this(webDriverFile.getAbsolutePath(), false);
    }
    private ChromeStepWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }
    private ChromeStepWebDriver(File webDriverFile) {
        this(webDriverFile.getAbsolutePath(), false);
    }
    private ChromeStepWebDriver() {}

}
