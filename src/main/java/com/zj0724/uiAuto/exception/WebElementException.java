package com.zj0724.uiAuto.exception;

/**
 * 元素异常
 *
 * @author ZJ
 * */
public final class WebElementException extends RuntimeException {

    /**
     * 构造函数
     *
     * @param message message
     * */
    public WebElementException(String message) {
        super(message);
    }

}