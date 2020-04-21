package com.zj0724.StepWebDriver.exception;

public class WebElementException extends RuntimeException {

    private String message;

    public WebElementException(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 元素未找到
     * */
    public static WebElementException elementNoFind() {
        return new WebElementException("元素未找到");
    }

}
