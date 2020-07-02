package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.GrammarException;
import com.zj0724.uiAuto.webElement.webElementException.WebElementNotFoundException;
import com.zj0724.uiAuto.webElement.WebElementProxy;
import org.openqa.selenium.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 抽象驱动类
 *
 * @author ZJ
 * */
public abstract class AbstractWebDriver implements WebDriver {

    /** 驱动文件 */
    protected File webDriverFile;

    /** 是否显示浏览器 */
    protected boolean headless;

    /** 驱动 */
    private org.openqa.selenium.WebDriver webDriver;

    /**
     * 构造函数
     * */
    protected AbstractWebDriver(File webDriverFile, boolean headless) {
        this.webDriverFile = webDriverFile;
        this.headless = headless;
        this.setWebDriver();
    }

    /**
     * 加载驱动
     *
     * @return 驱动
     * */
    protected abstract org.openqa.selenium.WebDriver loadWebDriver();

    /**
     * 设置驱动
     * */
    private void setWebDriver() {
        this.webDriver = loadWebDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public com.zj0724.uiAuto.WebElement findElementByCssSelector(String cssSelector) {
        try {
            return WebElementProxy.getWebElementProxy(webDriver.findElement(By.cssSelector(cssSelector)), cssSelector);
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(cssSelector);
        }
    }

    @Override
    public List<com.zj0724.uiAuto.WebElement> findElementsByCssSelector(String cssSelector) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.cssSelector(cssSelector));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(WebElementProxy.getWebElementProxy(element, cssSelector));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.cssGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(cssSelector);
        }
    }

    @Override
    public com.zj0724.uiAuto.WebElement findElementByXpath(String xpath) {
        try {
            return WebElementProxy.getWebElementProxy(webDriver.findElement(By.xpath(xpath)), xpath);
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(xpath);
        }
    }

    @Override
    public List<com.zj0724.uiAuto.WebElement> findElementsByXpath(String xpath) {
        try {
            List<com.zj0724.uiAuto.WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.findElements(By.xpath(xpath));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(WebElementProxy.getWebElementProxy(element, xpath));
            }
            return result;
        } catch (InvalidSelectorException e) {
            throw GrammarException.xpathGrammarException();
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(xpath);
        }
    }

    @Override
    public com.zj0724.uiAuto.WebElement findElementByText(String text) {
        return WebElementProxy.getWebElementProxy(this.webDriver.findElement(By.xpath("//*[contains(text(),\"" + text + "\")]")), text);
    }

    @Override
    public void await(int Millisecond) {
        try {
            Thread.sleep(Millisecond);
        } catch (InterruptedException e) {
            throw ErrorException.getInstance(e.getMessage());
        }
    }

    @Override
    public void url(String url) {
        try {
            this.webDriver.get(url);
        } catch (InvalidArgumentException e) {
            throw GrammarException.urlError();
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