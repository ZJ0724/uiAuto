package com.zj0724.uiAuto.exception;

public class WebElementException extends RuntimeException {

    public WebElementException(String message){
        super(message);
    }

    /**
     * 元素未找到
     * */
    public static WebElementException elementNotFind() {
        return new WebElementException("元素未找到");
    }

}
