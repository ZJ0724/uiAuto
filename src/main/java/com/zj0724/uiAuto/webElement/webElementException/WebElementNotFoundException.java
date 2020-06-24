package com.zj0724.uiAuto.webElement.webElementException;

import com.zj0724.uiAuto.webElement.WebElementException;

/**
 * 元素未找到异常
 *
 * @author ZJ
 * */
public final class WebElementNotFoundException extends WebElementException {

    /**
     * 构造函数
     * */
    protected WebElementNotFoundException(String message) {
        super(message);
    }

    /**
     * 获取异常实体
     *
     * @param selector 选择器
     *
     * @return 异常实体
     * */
    public static WebElementNotFoundException getInstance(String selector) {
        return new WebElementNotFoundException(selector);
    }

}