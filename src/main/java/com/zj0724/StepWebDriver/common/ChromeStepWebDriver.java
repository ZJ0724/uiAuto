package com.zj0724.StepWebDriver.common;

import com.zj0724.StepWebDriver.StepWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeStepWebDriver implements StepWebDriver {

    private final BaseStepWebDriver baseStepWebDriver;

    /**
     * 构造方法
     * */
    public ChromeStepWebDriver(String webDriverFilePath, boolean headless) {
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
            this.baseStepWebDriver = new BaseStepWebDriver(webDriver);
        } catch (IllegalStateException | WebDriverException e) {
            throw com.zj0724.StepWebDriver.exception.WebDriverException.driverFileError();
        }
    }

    public ChromeStepWebDriver(File webDriverFile, boolean headless) {
        this(webDriverFile.getAbsolutePath(), false);
    }

    public ChromeStepWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

    public ChromeStepWebDriver(File webDriverFile) {
        this(webDriverFile.getAbsolutePath(), false);
    }

    @Override
    public WebElement findElementByCssSelector(String cssSelector) {
        return this.baseStepWebDriver.findElementByCssSelector(cssSelector);
    }

    @Override
    public List<WebElement> findElementsByCssSelector(String cssSelector) {
        return this.baseStepWebDriver.findElementsByCssSelector(cssSelector);
    }

    @Override
    public WebElement findElementByXpath(String xpath) {
        return this.baseStepWebDriver.findElementByXpath(xpath);
    }

    @Override
    public List<WebElement> findElementsByXpath(String xpath) {
        return this.baseStepWebDriver.findElementsByXpath(xpath);
    }

    @Override
    public void await(int Millisecond) {
        this.baseStepWebDriver.await(Millisecond);
    }

    @Override
    public void url(String url) {
        this.baseStepWebDriver.url(url);
    }

    @Override
    public void close() {
        this.baseStepWebDriver.close();
    }

}
