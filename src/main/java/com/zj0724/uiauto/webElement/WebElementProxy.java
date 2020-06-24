package com.zj0724.uiauto.webElement;

import com.zj0724.uiauto.WebElement;
import com.zj0724.uiauto.exception.ErrorException;
import com.zj0724.uiauto.webElement.webElementException.WebElementNotFoundException;
import java.lang.reflect.*;

/**
 * WebElement代理增强类
 *
 * @author ZJ
 * */
public final class WebElementProxy implements InvocationHandler {

    /** WebElement实体 */
    private final WebElement webElement;

    /**
     * 构造函数
     * */
    private WebElementProxy(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            return method.invoke(this.webElement, args);
        } catch (UndeclaredThrowableException | IllegalAccessException | InvocationTargetException e) {
            try {
                throw e.getCause();
            } catch (org.openqa.selenium.StaleElementReferenceException throwable) { // 元素失效异常
                throw WebElementNotFoundException.getInstance(webElement.getSelector());
            } catch (Throwable e1) {
                throw ErrorException.getInstance(e1.getMessage());
            }
        }
    }

    /**
     * 获取代理增强类对象
     *
     * @param element 原始元素
     * @param selector 选择器
     *
     * @return 代理增强WebElement类
     * */
    public static WebElement getWebElementProxy(org.openqa.selenium.WebElement element, String selector) {
        WebElementProxy webElementProxy = new WebElementProxy(new BaseWebElement(element, selector));
        return (WebElement) Proxy.newProxyInstance(webElementProxy.getClass().getClassLoader(), WebElement.class.getInterfaces(), webElementProxy);
    }

}