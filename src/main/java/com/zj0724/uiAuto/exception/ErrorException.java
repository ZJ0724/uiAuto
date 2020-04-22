package com.zj0724.uiAuto.exception;

public class ErrorException extends RuntimeException {

    public ErrorException(String message) {
        super(message);
    }

    /**
     * 程序出现bug
     * */
    public static ErrorException bug(String message) {
        return new ErrorException("bug：" + message);
    }

}
