package com.zj0724.uiAuto.exception;

/**
 * 驱动异常
 *
 * @author ZJ
 * */
public final class WebDriverException extends RuntimeException {

    /**
     * 构造函数
     *
     * @param message message
     * */
    public WebDriverException(String message) {
        super(message);
    }

}