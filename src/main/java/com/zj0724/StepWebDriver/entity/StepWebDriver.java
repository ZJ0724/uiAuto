package com.zj0724.StepWebDriver.entity;

import com.zj0724.StepWebDriver.exception.GrammarException;
import com.zj0724.StepWebDriver.exception.UrlException;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepWebDriver {

    private WebDriver webDriver = null;

    public StepWebDriver(String webDriverFilePath, boolean headless) {
        try {
            System.setProperty("webdriver.chrome.driver", webDriverFilePath);
            ChromeOptions chromeOptions=new ChromeOptions();
            if (!headless) {
                chromeOptions.addArguments("headless");
            }
            chromeOptions.addArguments("start-maximized");
            ChromeDriver webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.webDriver = webDriver;
        } catch (IllegalStateException e) {
            throw new com.zj0724.StepWebDriver.exception.WebDriverException("驱动文件不存在");
        } catch (WebDriverException e) {
            throw new com.zj0724.StepWebDriver.exception.WebDriverException("驱动异常");
        }
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
    public WebElement findElementByCssSelector(String cssSelector) {
        try {
            return new WebElement(webDriver.findElement(By.cssSelector(cssSelector)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 查找元素
     * */
    public List<WebElement> findElementsByCssSelector(String cssSelector) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.cssSelector(cssSelector));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new WebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 查找元素
     * */
    public WebElement findElementByXpath(String xpath) {
        try {
            return new WebElement(webDriver.findElement(By.xpath(xpath)));
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 查找元素
     * */
    public List<WebElement> findElementsByXpath(String xpath) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.xpath(xpath));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new WebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * 打开网址
     * */
    public void url(String url) {
        try {
            this.webDriver.get(url);
        } catch (InvalidArgumentException e) {
            throw UrlException.getUrlException();
        }
    }

}
