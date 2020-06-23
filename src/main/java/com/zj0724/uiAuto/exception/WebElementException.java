package com.zj0724.uiAuto.exception;

public class WebElementException extends BaseException {

    private WebElementException(String message){
        super(message);
    }

    /**
     * 元素未找到
     * */
    public static WebElementException elementNotFind() {
        return new WebElementException("元素未找到");
    }

    /**
     * 元素不能输入
     * */
    public static WebElementException elementNotInput() {
        return new WebElementException("元素不能输入");
    }

}