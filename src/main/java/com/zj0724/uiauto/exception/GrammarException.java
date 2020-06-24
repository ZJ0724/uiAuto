package com.zj0724.uiauto.exception;

/**
 * 语法异常
 *
 * @author ZJ
 * */
public final class GrammarException extends RuntimeException {

    /**
     * 构造函数
     * */
    private GrammarException(String message) {
        super(message);
    }

    /**
     * css语法错误
     *
     * @return 异常实体
     * */
    public static GrammarException cssGrammarException() {
        return new GrammarException("css语法错误");
    }

    /**
     * xpath语法错误
     *
     * @return 异常实体
     * */
    public static GrammarException xpathGrammarException() {
        return new GrammarException("xpath语法错误");
    }

    /**
     * 网址错误
     *
     * @return 异常实体
     * */
    public static GrammarException urlError() {
        return new GrammarException("网址错误");
    }

}