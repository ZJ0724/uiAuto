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
        try {
            if (!waitIsClick) {
                this.element.click();
                return;
            }
        } catch (Exception e) {
            throw new WebElementException("元素不能点击");
        }

        // 等待元素可以点击之后点击
        long startTime = new Date().getTime() + 10000L;
        while (true) {
            long nowTime = new Date().getTime();
            if (startTime < nowTime) {
                throw new WebElementException("元素点击超时");
            }

            try {
                this.element.click();
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
    public void sendKeyByJs(String value) {
        String js = selector.getJsElement() + ".value = '" + value + "';";
        webDriver.executeScript(js);
    }

    @Override
    public WebElement parent() {
        try {
            return new BaseWebElement(element.findElement(By.xpath("./..")), selector, webDriver);
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    @Override
    public WebElement child(int index) {
        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./child::*[" + (index + 1) + "]")), selector, webDriver);
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public WebElement next() {
        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./following-sibling::*[1]")), selector, webDriver);
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public WebElement prev() {
        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./preceding-sibling::*[1]")), selector, webDriver);
        } catch (NoSuchElementException e) {
            throw new WebElementException(e.getMessage());
        }
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
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = this.element.findElements(By.xpath("./child::*"));
            for (org.openqa.selenium.WebElement e : elements) {
                result.add(new BaseWebElement(e, selector, webDriver));
            }
            return result;
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
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
        String js = "let element = " + selector.getJsElement() + ";\n" +
                "let event = document.createEvent(\"HTMLEvents\");\n" +
                "event.initEvent(\"" + event + "\", false, true);\n" +
                "element.dispatchEvent(event);";
        webDriver.executeScript(js);
    }

}