package com.zj0724.StepWebDriver.entity;

import org.openqa.selenium.By;

public class WebElement {

    private org.openqa.selenium.WebElement element = null;

    public WebElement(org.openqa.selenium.WebElement element) {
        this.element = element;
        System.out.println(this.element);
    }

    /**
     * 点击元素
     * */
    public boolean click() {
        element.click();

        return true;
    }

    /**
     * 输入
     * */
    public boolean sendKey(String value) {
        this.element.sendKeys(value);

        return true;
    }

    /**
     * 获取父级元素
     * */
    public WebElement parent() {
        return new WebElement(element.findElement(By.xpath("./..")));
    }

    /**
     * 获取属性值
     * */
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    /**
     * 获取子元素
     * */
    public WebElement children(int index) {
        if (index == 0) {
            return null;
        }

        return new WebElement(this.element.findElement(By.xpath("./child::*[" + (index) + "]")));
    }

    /**
     * 获取下一个元素
     * */
    public WebElement next() {
        return new WebElement(this.element.findElement(By.xpath("./following-sibling::*[1]")));
    }

    /**
     * 获取上一个元素
     * */
    public WebElement prev() {
        return new WebElement(this.element.findElement(By.xpath("./preceding-sibling::*[1]")));
    }

}
