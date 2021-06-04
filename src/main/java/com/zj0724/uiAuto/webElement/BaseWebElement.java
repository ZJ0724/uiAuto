package com.zj0724.uiAuto.webElement;

import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.exception.WebElementException;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基础WebElement实现类
 *
 * @author ZJ
 * */
public final class BaseWebElement implements WebElement {

    /**
     * 元素
     * */
    private final org.openqa.selenium.WebElement element;

    private final Selector selector;

    private final com.zj0724.uiAuto.WebDriver webDriver;

    /**
     * 构造方法
     *
     * @param element 元素
     * */
    public BaseWebElement(org.openqa.selenium.WebElement element, Selector selector, com.zj0724.uiAuto.WebDriver webDriver) {
        this.element = element;
        this.selector = selector;
        this.webDriver = webDriver;
    }

    @Override
    public void click() {
        this.click(true);
    }

    @Override
    public void click(boolean waitIsClick) {
        // 不等待点击元素
        if (!waitIsClick) {
            click(this.element);
            return;
        }

        // 等待元素可以点击之后点击
        long startTime = new Date().getTime() + 10000L;
        while (true) {
            long nowTime = new Date().getTime();
            if (startTime < nowTime) {
                throw new WebElementException("元素点击超时");
            }

            try {
                click(this.element);
                break;
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void sendKey(String value) {
        try {
            this.element.sendKeys(value);
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public void sendKey(Keys keys) {
        try {
            this.element.sendKeys(keys);
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public void sendKeyByJs(String value) {
        String js = selector.getJsDocument() + ".value = '" + value + "';";
        webDriver.executeScript(js);
    }

    @Override
    public WebElement parent() {
        List<WebElement> webElements = this.selector.getParent().getWebElements(this.webDriver);
        if (webElements.size() == 0) {
            throw new WebElementException("元素未找到: " + this.selector.getSelect());
        }
        return webElements.get(0);
    }

    @Override
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    @Override
    public WebElement child(int index) {
        return children().get(index);
    }

    @Override
    public WebElement next() {
        Selector next = this.selector.getNext();
        List<WebElement> webElements = next.getWebElements(webDriver);
        if (webElements.size() == 0) {
            throw new WebElementException("元素未找到: " + next.getSelect());
        }
        return webElements.get(0);
    }

    @Override
    public WebElement prev() {
        Selector prev = this.selector.getPrev();
        List<WebElement> webElements = prev.getWebElements(webDriver);
        if (webElements.size() == 0) {
            throw new WebElementException("元素未找到: " + prev.getSelect());
        }
        return webElements.get(0);
    }

    @Override
    public String toString() {
        if (this.element == null) {
            return "NULL";
        }

        return this.element.toString();
    }

    @Override
    public Integer getChildNumber() {
        return this.children().size();
    }

    @Override
    public String getText() {
        try {
            return this.element.getAttribute("innerText");
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public boolean isDisplay() {
        try {
            return this.element.isDisplayed();
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public List<WebElement> children() {
        List<WebElement> result = new ArrayList<>();
        List<Selector> children = this.selector.getChildren();
        for (Selector selector : children) {
            result.add(selector.getWebElements(webDriver).get(0));
        }
        return result;
    }

    @Override
    public void clear() {
        try {
            this.element.clear();
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public void event(String event) {
        String js = "let element = " + selector.getJsDocument() + ";\n" +
                "let event = document.createEvent(\"HTMLEvents\");\n" +
                "event.initEvent(\"" + event + "\", false, true);\n" +
                "element.dispatchEvent(event);";
        webDriver.executeScript(js);
    }

    @Override
    public String getTagName() {
        return this.element.getTagName();
    }

    private void click(org.openqa.selenium.WebElement webElement) {
        try {
            webElement.click();
        } catch (Exception e) {
            try {
                this.event("click");
            } catch (Exception e1) {
                throw new WebElementException(e1.getMessage());
            }
        }
    }

}