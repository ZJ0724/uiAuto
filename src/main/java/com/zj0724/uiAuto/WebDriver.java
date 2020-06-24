package com.zj0724.uiauto;

import java.util.List;

public interface WebDriver {

    /**
     * 通过cssSelector查找元素
     *
     * @param cssSelector css选择器
     *
     * @return WebElement 一个元素
     * */
    WebElement findElementByCssSelector(String cssSelector);

    /**
     * 通过cssSelector查找元素
     *
     * @param cssSelector css选择器
     *
     * @return List<WebElement> 返回一个元素集合
     * */
    List<WebElement> findElementsByCssSelector(String cssSelector);

    /**
     * 通过xpath查找元素
     *
     * @param xpath xpath语法
     *
     * @return WebElement 返回一个元素
     * */
    WebElement findElementByXpath(String xpath);

    /**
     * 通过xpath查找元素
     *
     * @param xpath xpath语法
     *
     * @return List<WebElement> 返回一个元素集合
     * */
    List<WebElement> findElementsByXpath(String xpath);

    /**
     * 线程等待
     *
     * @param Millisecond 要等待的毫秒数
     * */
    void await(int Millisecond);

    /**
     * 打开网址
     *
     * @param url 要打开的网址
     * */
    void url(String url);

    /**
     * 关闭驱动
     * */
    void close();

}