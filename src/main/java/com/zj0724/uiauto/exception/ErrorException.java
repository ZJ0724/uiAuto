package com.zj0724.uiauto.exception;

/**
 * 程序bug异常
 *
 * @author ZJ
 * */
public final class ErrorException extends RuntimeException {

    /**
     * 构造函数
     * */
    private ErrorException(String message) {
        super(message);
    }

    /**
     * 获取异常实体
     *
     * @return 异常实体
     * */
    public static ErrorException getInstance(String message) {
        return new ErrorException(message);
    }

}