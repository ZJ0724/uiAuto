package com.zj0724.uiAuto.webElement;

public interface Action {

    /**
     * 获取子元素个数
     * */
    Integer getChildNumber();

    /**
     * 获取元素文本
     * */
    String getText();

    /**
     * 元素是否存在
     * */
    boolean isDisplay();

}
