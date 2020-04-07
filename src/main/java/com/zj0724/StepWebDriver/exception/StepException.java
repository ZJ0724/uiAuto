package com.zj0724.StepWebDriver.exception;

public class StepException extends RuntimeException{

    private String message;

    public StepException(String message){
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