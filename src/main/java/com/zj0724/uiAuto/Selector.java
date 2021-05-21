package com.zj0724.uiAuto;

import com.zj0724.uiAuto.exception.WebElementException;
import com.zj0724.uiAuto.selector.CssSelector;
import com.zj0724.uiAuto.selector.TextSelector;
import com.zj0724.uiAuto.selector.XpathSelector;
import com.zj0724.uiAuto.webElement.BaseWebElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

/**
 * 元素选择器
 *
 * @author ZJ
 * */
public abstract class Selector {

    private final String select;

    private final String jsDocument;

    private org.openqa.selenium.WebElement seleniumElement;

    protected Selector(String select, String jsDocument) {
        this.select = select;
        this.jsDocument = jsDocument;
    }

    public String getSelect() {
        return select;
    }

    public String getJsDocument() {
        return jsDocument;
    }

    public org.openqa.selenium.WebElement getSeleniumElement() {
        return seleniumElement;
    }

    public void setSeleniumElement(org.openqa.selenium.WebElement seleniumElement) {
        this.seleniumElement = seleniumElement;
    }

    /**
     * 获取元素
     *
     * @param webDriver webDriver
     *
     * @return List<WebElement>
     * */
    public abstract List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver);

    /**
     * 获取父级
     *
     * @return Selector
     * */
    public final Selector getParent() {
        org.openqa.selenium.WebElement webElement = this.getSeleniumElement();
        if (webElement == null) {
            throw new WebElementException("当前未设置元素");
        }
        return new Selector(this.getSelect() + "/..", this.getJsDocument() + ".parentElement") {
            @Override
            public List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver) {
                List<WebElement> result = new ArrayList<>();
                try {
                    org.openqa.selenium.WebElement element = webElement.findElement(By.xpath("./.."));
                    this.setSeleniumElement(element);
                    result.add(new BaseWebElement(element, this, webDriver));
                    return result;
                } catch (Exception e) {
                    throw new WebElementException(e.getMessage());
                }
            }
        };
    }

    /**
     * 获取子元素
     *
     * @return List<Selector>
     * */
    public final List<Selector> getChildren() {
        List<Selector> result = new ArrayList<>();
        org.openqa.selenium.WebElement seleniumElement = this.getSeleniumElement();
        if (seleniumElement == null) {
            throw new WebElementException("当前未设置元素");
        }
        List<org.openqa.selenium.WebElement> elements = seleniumElement.findElements(By.xpath("./child::*"));
        for (int i = 0 ; i < elements.size(); i++) {
            int finalI = i;
            result.add(new Selector(this.getSelect() + "/child[" + finalI + "]", this.getJsDocument() + ".children[" + finalI + "]") {
                @Override
                public List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver) {
                    List<WebElement> result = new ArrayList<>();
                    org.openqa.selenium.WebElement webElement = elements.get(finalI);
                    this.setSeleniumElement(webElement);
                    try {
                        result.add(new BaseWebElement(webElement.findElement(By.xpath("./child::*[" + (finalI + 1) + "]")), this, webDriver));
                        return result;
                    } catch (Exception e) {
                        throw new WebElementException(e.getMessage());
                    }
                }
            });
        }
        return result;
    }

    /**
     * 获取下一个元素
     *
     * @return Selector
     * */
    public final Selector getNext() {
        org.openqa.selenium.WebElement webElement = this.getSeleniumElement();
        if (webElement == null) {
            throw new WebElementException("当前未设置元素");
        }
        return new Selector(this.getSelect() + ".nextElementSibling", this.getJsDocument() + ".nextElementSibling") {
            @Override
            public List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver) {
                List<WebElement> result = new ArrayList<>();
                try {
                    org.openqa.selenium.WebElement element = webElement.findElement(By.xpath("./following-sibling::*[1]"));
                    this.setSeleniumElement(element);
                    result.add(new BaseWebElement(element, this, webDriver));
                    return result;
                } catch (Exception e) {
                    throw new WebElementException(e.getMessage());
                }
            }
        };
    }

    /**
     * 获取上一个元素
     *
     * @return Selector
     * */
    public final Selector getPrev() {
        org.openqa.selenium.WebElement webElement = this.getSeleniumElement();
        if (webElement == null) {
            throw new WebElementException("当前未设置元素");
        }
        return new Selector(this.getSelect() + ".previousElementSibling", this.getJsDocument() + ".previousElementSibling") {
            @Override
            public List<WebElement> getWebElements(com.zj0724.uiAuto.WebDriver webDriver) {
                List<WebElement> result = new ArrayList<>();
                try {
                    org.openqa.selenium.WebElement element = webElement.findElement(By.xpath("./preceding-sibling::*[1]"));
                    this.setSeleniumElement(element);
                    result.add(new BaseWebElement(element, this, webDriver));
                    return result;
                } catch (Exception e) {
                    throw new WebElementException(e.getMessage());
                }
            }
        };
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