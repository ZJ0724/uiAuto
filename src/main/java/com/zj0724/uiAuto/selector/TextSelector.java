package com.zj0724.uiAuto.selector;

import com.zj0724.uiAuto.Selector;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.webElement.BaseWebElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本查找器
 *
 * @author ZJ
 * */
public final class TextSelector extends Selector {

    public TextSelector(String select) {
        super(select, "document.evaluate('//*[contains(text(), \"" + select + "\")]', document).iterateNext()");
    }

    @Override
    public List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver) {
        try {
            List<WebElement> result = new ArrayList<>();
            List<org.openqa.selenium.WebElement> elements = webDriver.getSeleniumWebDriver().findElements(By.xpath("//*[contains(text(),\"" + this.getSelect() + "\")]"));
            for (org.openqa.selenium.WebElement element : elements) {
                this.setSeleniumElement(element);
                result.add(new BaseWebElement(element, this, webDriver));
            }
            return result;
        } catch (Exception e) {
            throw new WebElementException(e.getMessage());
        }
    }

}