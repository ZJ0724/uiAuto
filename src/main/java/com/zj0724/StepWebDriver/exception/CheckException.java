package com.zj0724.StepWebDriver.exception;

public class CheckException extends RuntimeException {

    public CheckException(String message) {
        super(message);
    }

    /**
     * 参数为空
     * */
    public static CheckException parameterNotNull() {
        throw new CheckException("参数不能为空");
    }

}
