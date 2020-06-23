package com.zj0724.uiAuto.exception.webElement;

import com.zj0724.uiAuto.exception.BaseException;

/**
 * 元素未找到异常
 * */
public class WebElementNotFoundException extends BaseException {

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