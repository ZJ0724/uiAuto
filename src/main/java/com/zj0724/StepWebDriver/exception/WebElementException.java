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

}