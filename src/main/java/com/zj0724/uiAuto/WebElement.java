package com.zj0724.uiAuto;

import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.webElement.Action;
import org.openqa.selenium.*;

public class WebElement implements Action {

    private org.openqa.selenium.WebElement element = null;

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
            throw WebElementException.elementNotClick();
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
