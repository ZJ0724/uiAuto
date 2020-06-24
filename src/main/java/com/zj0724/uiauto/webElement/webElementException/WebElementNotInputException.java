package com.zj0724.uiauto.webElement.webElementException;

import com.zj0724.uiauto.webElement.WebElementException;

/**
 * 元素不能输入异常
 *
 * @author ZJ
 * */
public class WebElementNotInputException extends WebElementException {

    /**
     * 构造函数
     * */
    private WebElementNotInputException(String message) {
        super(message);
    }

    /**
     * 获取异常实体
     *
     * @return 异常实体
     * */
    public static WebElementNotInputException getInstance() {
        return new WebElementNotInputException("元素不能输入");
    }

}