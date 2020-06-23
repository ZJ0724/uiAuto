package com.zj0724.uiAuto.exception.webElement;

import com.zj0724.uiAuto.exception.BaseException;

/**
 * 元素不能点击异常
 *
 * @author ZJ
 * */
public class WebElementNotClickException extends BaseException {

    protected WebElementNotClickException(String message) {
        super(message);
    }

    /**
     * 获取异常实体
     *
     * @param selector 选择器
     *
     * @return 异常实体
     * */
    public static WebElementNotClickException getInstance(String selector) {
        return new WebElementNotClickException(selector);
    }

}