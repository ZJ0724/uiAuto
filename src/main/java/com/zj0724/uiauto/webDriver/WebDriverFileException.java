package com.zj0724.uiauto.webDriver;

/**
 * 驱动文件异常
 *
 * @author ZJ
 * */
public class WebDriverFileException extends RuntimeException {

    /**
     * 构造函数
     * */
    private WebDriverFileException(String message) {
        super(message);
    }

    /**
     * 获取异常实体
     *
     * @return 异常实体
     * */
    public static WebDriverFileException getInstance() {
        return new WebDriverFileException("驱动文件错误，如果存在进程，请手动结束掉进程");
    }

}