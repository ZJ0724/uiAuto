package com.zj0724.StepWebDriver.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StepUtil {

    /**
     * 获取element和action
     * */
    public static List<String> getXpathAndAction(String step){
        //将step的主元素使用占位符替换
        String mainElement = RegularUtil.get(step,"^\\$\\(\"(.*?)\"\\)").get(0);
        String placeholder = new Date().getTime()+"zj0724";
        step=step.replace(mainElement,placeholder);

        //获取element和action
        String[] steps = step.split("\\.");
        String element = "";
        for (int i = 0;i<steps.length-1;i++) {
            element = element+"."+steps[i];
        }
        element = element.substring(1);
        element = element.replace(placeholder,mainElement);
        String action = steps[steps.length-1];

        //将element转换成xpath
        String[] elements = element.split("\\.");
        String xpath = "//";
        //解析主元素
        if (mainElement.contains("[")) {
            xpath=xpath+mainElement.substring(0,mainElement.indexOf("["));
            List<String> attributes = RegularUtil.get(mainElement,"\\[(.*?)\\]");
            for (String attribute : attributes) {
                int denHaoIndex = attribute.indexOf("=");
                String key = attribute.substring(0,denHaoIndex);
                String value = attribute.substring(denHaoIndex+1);
                if (key.contains("text()")) {
                    xpath=xpath+"[contains(text(),\""+value+"\")]";
                } else {
                    xpath=xpath+"[@"+key+"=\""+value+"\"]";
                }
            }
        } else {
            xpath=xpath+mainElement;
        }
        //解析第几个主元素
        String elements_1 = elements[0];
        if (elements_1.substring(elements_1.length()-1).equals("]")) {
            String index = RegularUtil.get(elements_1,"\"\\)\\[(.*?)\\]").get(0);
            xpath=xpath+"["+index+"]";
        } else {
            xpath=xpath+"[1]";
        }
        //解析依赖元素
        for (int i = 1;i<elements.length;i++) {
            String e = elements[i];
            if (e.equals("parent()")) {
                xpath=xpath+"/..";
                continue;
            }
            if (e.equals("next()")) {
                xpath=xpath+"/following-sibling::*[1]";
                continue;
            }
            if (e.equals("prev()")) {
                xpath=xpath+"/preceding-sibling::*[1]";
                continue;
            }
            if (e.equals("children()")) {
                xpath=xpath+"/*[1]";
            } else {
                String index = RegularUtil.get(e,"children\\(\\)\\[(.*?)\\]").get(0);
                xpath=xpath+"/*["+index+"]";
            }
        }

        List<String> result = new ArrayList<>();
        result.add(xpath);
        result.add(action);
        return result;
    }

}