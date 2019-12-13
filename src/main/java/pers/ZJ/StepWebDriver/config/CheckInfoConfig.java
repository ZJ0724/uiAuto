package pers.ZJ.StepWebDriver.config;

import java.util.ArrayList;
import java.util.List;

public class CheckInfoConfig {

    /**
     * 浏览器操作
     */
    public static final List<String> BROWSER_ACTIONS = new ArrayList<>();

    static {
        BROWSER_ACTIONS.add("^wait\\([1-9][0-9]*\\)$");
        BROWSER_ACTIONS.add("^url\\(\"(.*?)\"\\)$");
        BROWSER_ACTIONS.add("^switchTo\\(\"(.*?)\"\\)$");
    }

    /**
     * 元素操作
     * */
    public static final String ELEMENT_ACTION = "^\\$(\\(\"(.*?)\"\\))((\\[[1-9][0-9]*\\])?)" +
            "(((.parent\\(\\))|(.children\\(\\))(\\[[1-9][0-9]*\\])?|(.next\\(\\))|(.prev\\(\\)))*)" +
            "((.click\\(\\))|(.sendKey\\(\"(.*?)\"\\))|(.sendKey\\(\\?\\))|(.clear\\(\\))|(.display\\(([1-9][0-9]*)?\\)))$";

}