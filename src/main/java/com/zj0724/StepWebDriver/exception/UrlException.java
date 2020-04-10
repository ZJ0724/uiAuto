package com.zj0724.StepWebDriver.exception;

public class UrlException extends RuntimeException {

    private String message;

    public UrlException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * url异常
     * */
    public static UrlException getUrlException() {
        return new UrlException("url地址错误");
    }

}
