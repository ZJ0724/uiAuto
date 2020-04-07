package com.zj0724.StepWebDriver.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumUtil {

    /**
     * 获取谷歌驱动
     * */
    public static ChromeDriver getChromeDriver(File webDriverFile, boolean headless) {
        System.setProperty("webdriver.chrome.driver",webDriverFile.getPath());
        ChromeOptions chromeOptions=new ChromeOptions();
        if (!headless) {
            chromeOptions.addArguments("headless");
        }
        chromeOptions.addArguments("start-maximized");
        ChromeDriver webDriver=new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

    /**
     * 获取元素
     * */
    public static WebElement getWebElement(WebDriver webDriver, String xpath){
        return webDriver.findElement(By.xpath(xpath));
    }

    /**
     * 关闭驱动
     * */
    public static void closeWebDriver(WebDriver webDriver){
        if(webDriver!=null){
            webDriver.close();
            webDriver.quit();
        }
    }

    /**
     * 打开网址
     * */
    public static void openUrl(WebDriver webDriver, String url){
        if(url.equals("")){
            return;
        }
        webDriver.get(url);
        webDriver.navigate().refresh();
    }

}