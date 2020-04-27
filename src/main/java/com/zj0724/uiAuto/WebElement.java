package com.zj0724.uiAuto;

import com.zj0724.uiAuto.exception.WebElementException;
import org.openqa.selenium.*;

public class WebElement {

    private org.openqa.selenium.WebElement element = null;

    public WebElement() {
        throw WebElementException.elementNotFind();
    }
    public WebElement(org.openqa.selenium.WebElement element) {
        this.element = element;
    }

    /**
     * 点击元素
     * */
    public void click() {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw new WebElementException("元素不能被点击");
        }
    }

    /**
     * 输入框输入参数
     *
     * @param value 要输入的参数
     * */
    public void sendKey(String value) {
        try {
            this.element.sendKeys(value);
        } catch (ElementNotInteractableException e) {
            throw new WebElementException("元素不能输入内容");
        }
    }

    /**
     * 获取父级元素
     *
     * @return 返回父级元素，如果不存在父级元素，抛出元素未找到异常
     * */
    public WebElement parent() {
        try {
            return new WebElement(element.findElement(By.xpath("./..")));
        } catch (InvalidSelectorException e) {
            return new WebElement();
        }
    }

    /**
     * 获取元素属性值
     *
     * @param name 元素属性名
     * */
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    /**
     * 获取子元素
     *
     * @param index 元素索引，从1开始
     *
     * @return 返回子元素，如果不存在，抛出元素未找到异常
     * */
    public WebElement children(int index) {
        if (index == 0) {
            return new WebElement();
        }

        try {
            return new WebElement(this.element.findElement(By.xpath("./child::*[" + (index) + "]")));
        } catch (NoSuchElementException e) {
            return new WebElement();
        }
    }

    /**
     * 获取下一个元素
     *
     * @return 返回同级下一个元素，如果不存在，抛出元素未找到异常
     * */
    public WebElement next() {
        try {
            return new WebElement(this.element.findElement(By.xpath("./following-sibling::*[1]")));
        } catch (NoSuchElementException e) {
            return new WebElement();
        }
    }

    /**
     * 获取上一个元素
     *
     * @return 返回同级上一个元素，如果不存在，抛出元素未找到异常
     * */
    public WebElement prev() {
        try {
            return new WebElement(this.element.findElement(By.xpath("./preceding-sibling::*[1]")));
        } catch (NoSuchElementException e) {
            return new WebElement();
        }
    }

    @Override
    public String toString() {
        return this.element.toString();
    }

}
