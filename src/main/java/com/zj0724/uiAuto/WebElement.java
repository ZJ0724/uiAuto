package com.zj0724.uiAuto;

import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.exception.WebElementNotClickException;
import com.zj0724.uiAuto.webElement.Action;
import org.openqa.selenium.*;
import java.util.Date;

public class WebElement implements Action {

    private final org.openqa.selenium.WebElement element;

    public WebElement() {
        throw WebElementException.elementNotFind();
    }
    public WebElement(org.openqa.selenium.WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw WebElementNotClickException.getInstance(this);
        }
    }

    @Override
    public void click(boolean waitIsClick) {
        if (!waitIsClick) {
            this.click();
            return;
        }

        // 开始时间
        long startTime = new Date().getTime() + 10000L;

        while (true) {
            // 如果超时时间 < 当前时间时，退出、抛出异常
            long nowTime = new Date().getTime();
            if (startTime < nowTime) {
                throw WebElementNotClickException.getInstance(this);
            }

            try {
                this.click();
                break;
            } catch (WebElementNotClickException e) {
                System.out.println("wait element ...");
            }
        }
    }

    @Override
    public void sendKey(String value) {
        try {
            this.element.sendKeys(value);
        } catch (ElementNotInteractableException e) {
            throw WebElementException.elementNotInput();
        }
    }

    @Override
    public WebElement parent() {
        try {
            return new WebElement(element.findElement(By.xpath("./..")));
        } catch (InvalidSelectorException e) {
            return new WebElement();
        }
    }

    @Override
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    @Override
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

    @Override
    public WebElement next() {
        try {
            return new WebElement(this.element.findElement(By.xpath("./following-sibling::*[1]")));
        } catch (NoSuchElementException e) {
            return new WebElement();
        }
    }

    @Override
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

    @Override
    public Integer getChildNumber() {
        return this.element.findElements(By.xpath("./child::*")).size();
    }

    @Override
    public String getText() {
        return this.element.getAttribute("innerText");
    }

    @Override
    public boolean isDisplay() {
        return this.element.isDisplayed();
    }

}