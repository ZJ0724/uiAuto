package com.zj0724.StepWebDriver.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class ChromeStepWebDriver {

    private final WebDriver webDriver;

    /**
     * 获取一个谷歌驱动
     * */
    public ChromeStepWebDriver getChromeStepWebDriver(String chromeDriverPath) {
        return new ChromeStepWebDriver(chromeDriverPath);
    }

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
        } catch (IllegalStateException e) {
            throw new com.zj0724.StepWebDriver.exception.WebDriverException("驱动文件不存在");
        } catch (WebDriverException e) {
            throw new com.zj0724.StepWebDriver.exception.WebDriverException("驱动异常");
        }
    }

    private ChromeStepWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

}
