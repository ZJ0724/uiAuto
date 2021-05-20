package com.zj0724.uiAuto.selector;

import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.webElement.BaseWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

/**
 * CssSelector
 *
 * @author ZJ
 * */
public final class CssSelector extends Selector {

    public CssSelector(String select) {
        super(select);
    }

    @Override
    public List<WebElement> getWebElements(WebDriver seleniumWebDriver, com.zj0724.uiAuto.WebDriver webDriver) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = seleniumWebDriver.findElements(By.cssSelector(this.getSelect()));
            for (org.openqa.selenium.WebElement element : elements) {
                result.add(new BaseWebElement(element, this, webDriver));
            }
            return result;
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

    @Override
    public String getJsElement() {
        return "document.querySelector('" + this.getSelect() + "')";
    }

}