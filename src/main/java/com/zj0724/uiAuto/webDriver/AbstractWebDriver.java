package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.GrammarException;
import com.zj0724.uiAuto.exception.WebElementException;
import org.openqa.selenium.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * AbstractWebDriver
 *
 * @author ZJ
 * */
public abstract class AbstractWebDriver implements WebDriver {

    private org.openqa.selenium.WebDriver seleniumWebDriver;

    protected AbstractWebDriver(org.openqa.selenium.WebDriver webDriver) {
        this.seleniumWebDriver = webDriver;
        this.seleniumWebDriver.manage().window().maximize();
        this.seleniumWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public final org.openqa.selenium.WebDriver getSeleniumWebDriver() {
        return seleniumWebDriver;
    }

    @Override
    public final List<com.zj0724.uiAuto.WebElement> findElements(Selector selector) {
        List<com.zj0724.uiAuto.WebElement> webElements = selector.getWebElements(this);
        if (webElements.size() == 0) {
            throw new WebElementException("元素未找到：" + selector.getSelect());
        }
        return webElements;
    }

    @Override
    public final com.zj0724.uiAuto.WebElement findElement(Selector selector) {
        return findElements(selector).get(0);
    }

    @Override
    public final void await(int Millisecond) {
        try {
            Thread.sleep(Millisecond);
        } catch (InterruptedException e) {
            throw new ErrorException(e);
        }
    }

    @Override
    public final void open(String url) {
        try {
            this.seleniumWebDriver.get(url);
        } catch (InvalidArgumentException e) {
            throw new GrammarException(e.getMessage());
        }
    }

    @Override
    public final void close() {
        if (this.seleniumWebDriver != null) {
            this.seleniumWebDriver.quit();
            this.seleniumWebDriver = null;
        }
    }

    @Override
    public final void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) this.seleniumWebDriver;
        js.executeScript(script);
    }

    @Override
    public final com.zj0724.uiAuto.WebElement display(Selector selector, int Millisecond) {
        return display(selector, Millisecond, System.currentTimeMillis());
    }

    private com.zj0724.uiAuto.WebElement display(Selector selector, int Millisecond, long startTime) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime > Millisecond) {
            throw new WebElementException("等待超时，元素未找到");
        }
        try {
            return this.findElement(selector);
        } catch (Exception e) {
            return display(selector, Millisecond, startTime);
        }
    }

}