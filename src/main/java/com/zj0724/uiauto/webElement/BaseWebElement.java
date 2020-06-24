package com.zj0724.uiauto.webElement;

import com.zj0724.uiauto.WebElement;
import com.zj0724.uiauto.webElement.webElementException.WebElementNotClickException;
import com.zj0724.uiauto.webElement.webElementException.WebElementNotFoundException;
import com.zj0724.uiauto.webElement.webElementException.WebElementNotInputException;
import org.openqa.selenium.*;
import java.util.Date;

/**
 * 基础WebElement实现类
 *
 * @author ZJ
 * */
public class BaseWebElement implements WebElement {

    /** 元素 */
    private final org.openqa.selenium.WebElement element;

    /** 选择器 */
    private final String selector;

    /**
     * 构造方法
     * */
    protected BaseWebElement(org.openqa.selenium.WebElement element, String selector) {
        this.selector = selector;
        this.element = element;
    }

    @Override
    public void click() {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw WebElementNotClickException.getInstance(selector);
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
                throw WebElementNotClickException.getInstance(selector);
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
            throw WebElementNotInputException.getInstance();
        }
    }

    @Override
    public WebElement parent() {
        String selector1 = this.selector + "/parent()";
        try {
            return new BaseWebElement(element.findElement(By.xpath("./..")), selector1);
        } catch (InvalidSelectorException e) {
            throw WebElementNotFoundException.getInstance(selector1);
        }
    }

    @Override
    public String getAttribute(String name) {
        return this.element.getAttribute(name);
    }

    @Override
    public WebElement children(int index) {
        String selector1 = this.selector + "/children(" + index + ")";

        if (index == 0) {
            throw WebElementNotFoundException.getInstance(selector1);
        }

        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./child::*[" + (index) + "]")), selector1);
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(selector1);
        }
    }

    @Override
    public WebElement next() {
        String selector1 = this.selector + "/next()";

        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./following-sibling::*[1]")), selector1);
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(selector1);
        }
    }

    @Override
    public WebElement prev() {
        String selector1 = this.selector + "/prev()";

        try {
            return new BaseWebElement(this.element.findElement(By.xpath("./preceding-sibling::*[1]")), selector1);
        } catch (NoSuchElementException e) {
            throw WebElementNotFoundException.getInstance(selector1);
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

    @Override
    public String getSelector() {
        return this.selector;
    }

}