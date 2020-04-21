package com.zj0724.StepWebDriver.exception;

public class GrammarException extends RuntimeException {

    public GrammarException(String message) {
        super(message);
    }

    /**
     * css语法错误
     * */
    public static GrammarException cssGrammarException() {
        return new GrammarException("css语法错误");
    }

    /**
     * xpath语法错误
     * */
    public static GrammarException xpathGrammarException() {
        return new GrammarException("xpath语法错误");
    }

    /**
     * 网址错误
     * */
    public static GrammarException urlError() {
        return new GrammarException("网址错误");
    }

}
