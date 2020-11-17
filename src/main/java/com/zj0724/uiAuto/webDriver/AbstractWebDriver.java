package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.GrammarException;
import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.webElement.BaseWebElement;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 抽象驱动类
 *
 * @author ZJ
 * */
public abstract class AbstractWebDriver implements WebDriver {

    /**
     * 驱动
     * */
    private org.openqa.selenium.WebDriver webDriver;

    /**
     * 构造函数
     * */
    protected AbstractWebDriver() {
        this.webDriver = this.loadWebDriver();

        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * 加载驱动
     *
     * @return 驱动
     * */
    protected abstract org.openqa.selenium.WebDriver loadWebDriver();

    @Override
    public com.zj0724.uiAuto.WebElement findElementByCssSelector(String cssSelector) {
        try {
            return new BaseWebElement(webDriver.findElement(By.cssSelector(cssSelector)));
        } catch (InvalidSelectorException e) {
            throw new GrammarException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public List<com.zj0724.uiAuto.WebElement> findElementsByCssSelector(String cssSelector) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.cssSelector(cssSelector));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new BaseWebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw new GrammarException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public com.zj0724.uiAuto.WebElement findElementByXpath(String xpath) {
        try {
            return new BaseWebElement(webDriver.findElement(By.xpath(xpath)));
        } catch (InvalidSelectorException e) {
            throw new GrammarException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public List<com.zj0724.uiAuto.WebElement> findElementsByXpath(String xpath) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.xpath(xpath));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new BaseWebElement(element));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw new GrammarException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public com.zj0724.uiAuto.WebElement findElementByText(String text) {
        try {
            return new BaseWebElement(this.webDriver.findElement(By.xpath("//*[contains(text(),\"" + text + "\")]")));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public void await(int Millisecond) {
        try {
            Thread.sleep(Millisecond);
        } catch (InterruptedException e) {
            throw new ErrorException(e);
        }
    }

    @Override
    public void open(String url) {
        try {
            this.webDriver.get(url);
        } catch (InvalidArgumentException e) {
            throw new GrammarException(e.getMessage());
        }
    }

    @Override
    public void close() {
        if (this.webDriver != null) {
            this.webDriver.quit();
            this.webDriver = null;
        }
    }

}