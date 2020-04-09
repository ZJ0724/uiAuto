package com.zj0724.StepWebDriver.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class StepWebDriver {

    private WebDriver webDriver = null;

    public StepWebDriver(String webDriverFilePath, boolean headless) {
        System.setProperty("webdriver.chrome.driver", webDriverFilePath);
        ChromeOptions chromeOptions=new ChromeOptions();
        if (!headless) {
            chromeOptions.addArguments("headless");
        }
        chromeOptions.addArguments("start-maximized");
        ChromeDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver = webDriver;
    }

    public StepWebDriver(File webDriverFile, boolean headless) {
        this(webDriverFile.getPath(), headless);
    }

    public StepWebDriver(String webDriverFilePath) {
        this(webDriverFilePath, false);
    }

    public StepWebDriver(File webDriverFile) {
        this(webDriverFile, false);
    }

    /**
     * 查找元素
     * */
    public WebElement findByCssSelector(String cssSelector) {
        return new WebElement(webDriver.findElement(By.cssSelector(cssSelector)));
    }

    /**
     * 打开网址
     * */
    public void url(String url) {
        this.webDriver.get(url);
    }

}
