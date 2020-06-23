package com.zj0724.uiAuto.exception;

import com.zj0724.uiAuto.WebElement;

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
     * @param webElement 元素实体
     *
     * @return 异常实体
     * */
    public static WebElementNotClickException getInstance(WebElement webElement) {
        return new WebElementNotClickException(webElement.toString());
    }

}