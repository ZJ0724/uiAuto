package com.zj0724.uiAuto.exception;

public class WebDriverException extends RuntimeException {

    public WebDriverException(String message) {
        super(message);
    }

    /**
     * 驱动文件错误
     * */
    public static WebDriverException driverFileError() {
        return new WebDriverException("驱动文件错误");
    }

}
