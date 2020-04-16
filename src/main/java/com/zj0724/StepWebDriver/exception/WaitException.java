package com.zj0724.StepWebDriver.exception;

public class WaitException extends RuntimeException {

    private String message;

    public WaitException(String message) {
        super(message);
    }

}
