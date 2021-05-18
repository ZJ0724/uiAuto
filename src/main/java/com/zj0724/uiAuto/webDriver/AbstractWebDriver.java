package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.GrammarException;
import com.zj0724.uiAuto.exception.WebElementException;
import org.openqa.selenium.*;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 抽象驱动类
 *
 * @author ZJ
 * */
public abstract class AbstractWebDriver implements WebDriver {

    /**
     * 驱动文件
     * */
    protected final File webDriverFile;

    /**
     * 是否显示浏览器
     * */
    protected final boolean isShow;

    /**
     * 驱动
     * */
    private org.openqa.selenium.WebDriver webDriver;

    /**
     * 构造函数
     *
     * @param webDriverFile webDriverFile
     * @param isShow isShow
     * */
    protected AbstractWebDriver(File webDriverFile, boolean isShow) {
        this.webDriverFile = webDriverFile;
        this.isShow = isShow;
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
    public com.zj0724.uiAuto.WebElement findElement(Selector selector) {
        return findElements(selector).get(0);
    }

    @Override
    public List<com.zj0724.uiAuto.WebElement> findElements(Selector selector) {
        List<com.zj0724.uiAuto.WebElement> webElements = selector.getWebElements(this.webDriver);
        if (webElements.size() == 0) {
            throw new WebElementException("元素未找到：" + selector.getSelect());
        }
        return webElements;
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

    @Override
    public void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        js.executeScript(script);
    }

    @Override
    public com.zj0724.uiAuto.WebElement display(Selector selector, int Millisecond) {
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