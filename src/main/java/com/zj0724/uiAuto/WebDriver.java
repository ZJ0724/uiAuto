package com.zj0724.uiAuto;

import java.util.List;

public interface WebDriver {

    /**
     * 查找元素
     *
     * @param selector selector
     *
     * @return WebElement
     * */
    WebElement findElement(Selector selector);

    /**
     * 查找元素
     *
     * @param selector selector
     *
     * @return WebElement
     * */
    List<WebElement> findElements(Selector selector);

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
    void open(String url);

    /**
     * 关闭驱动
     * */
    void close();

    /**
     * 执行脚本
     *
     * @param script script
     * */
    void executeScript(String script);

    /**
     * 等待元素出现
     *
     * @param selector selector
     * @param Millisecond 毫秒
     * */
    WebElement display(Selector selector, int Millisecond);

    /**
     * 等待元素出现
     *
     * @param selector selector
     * */
    default WebElement display(Selector selector) {
        return display(selector, 60 * 1000);
    }

}