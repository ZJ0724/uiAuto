package com.zj0724.uiAuto.webElement;

import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.exception.ErrorException;
import com.zj0724.uiAuto.exception.webElement.WebElementNotFoundException;
import java.lang.reflect.*;

/**
 * WebElement代理增强类
 *
 * @author ZJ
 * */
public class WebElementProxy implements InvocationHandler {

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
                throw ErrorException.bug(e1.getMessage());
            }
        }
    }

    /**
     * 获取代理增强类对象
     * */
    public static WebElement getWebElementProxy(WebElement webElement) {
        WebElementProxy webElementProxy = new WebElementProxy(webElement);
        return (WebElement) Proxy.newProxyInstance(webElementProxy.getClass().getClassLoader(), webElement.getClass().getInterfaces(), webElementProxy);
    }

}