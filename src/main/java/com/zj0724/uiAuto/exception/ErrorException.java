package com.zj0724.uiAuto.exception;

/**
 * 程序bug异常
 *
 * @author ZJ
 * */
public final class ErrorException extends Error {

    /**
     * 构造函数
     *
     * @param message message
     * */
    public ErrorException(String message) {
        super(message);
    }

    /**
     * 构造函数
     *
     * @param e 异常
     * */
    public ErrorException(Exception e) {
        this(e.getMessage());
    }

}