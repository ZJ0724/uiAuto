package com.zj0724.uiAuto.exception;

/**
 * 语法异常
 *
 * @author ZJ
 * */
public final class GrammarException extends RuntimeException {

    /**
     * 构造函数
     *
     * @param message message
     * */
    public GrammarException(String message) {
        super(message);
    }

}