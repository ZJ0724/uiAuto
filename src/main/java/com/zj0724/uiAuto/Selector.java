package com.zj0724.uiAuto;

import com.zj0724.uiAuto.selector.CssSelector;
import com.zj0724.uiAuto.selector.TextSelector;
import com.zj0724.uiAuto.selector.XpathSelector;
import org.openqa.selenium.WebDriver;
import java.util.List;

/**
 * 元素选择器
 *
 * @author ZJ
 * */
public abstract class Selector {

    private final String select;

    protected Selector(String select) {
        this.select = select;
    }

    public abstract List<WebElement> getWebElements(WebDriver seleniumWebDriver, com.zj0724.uiAuto.WebDriver webDriver);

    public abstract String getJsElement();

    public String getSelect() {
        return select;
    }

    /**
     * 通过CssSelector查找
     *
     * @param select select
     *
     * @return 元素选择器
     * */
    public static Selector byCssSelector(String select) {
        return new CssSelector(select);
    }

    /**
     * 通过xpath查找
     *
     * @param select select
     *
     * @return 元素选择器
     * */
    public static Selector byXpath(String select) {
        return new XpathSelector(select);
    }

    /**
     * 通过文本查找
     *
     * @param select select
     *
     * @return 元素选择器
     * */
    public static Selector byText(String select) {
        return new TextSelector(select);
    }

}