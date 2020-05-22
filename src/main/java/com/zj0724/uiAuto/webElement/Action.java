package com.zj0724.uiAuto.webElement;

import com.zj0724.uiAuto.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public interface Action {

    /**
     * 点击元素
     * */
    void click();

    /**
     * 输入框输入参数
     *
     * @param value 要输入的参数
     * */
    void sendKey(String value);

    /**
     * 获取父级元素
     *
     * @return 返回父级元素，如果不存在父级元素，抛出元素未找到异常
     * */
    WebElement parent();

    /**
     * 获取元素属性值
     *
     * @param name 元素属性名
     * */
    String getAttribute(String name);

    /**
     * 获取子元素
     *
     * @param index 元素索引，从1开始
     *
     * @return 返回子元素，如果不存在，抛出元素未找到异常
     * */
    WebElement children(int index);

    /**
     * 获取下一个元素
     *
     * @return 返回同级下一个元素，如果不存在，抛出元素未找到异常
     * */
    WebElement next();

    /**
     * 获取上一个元素
     *
     * @return 返回同级上一个元素，如果不存在，抛出元素未找到异常
     * */
    WebElement prev();

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
