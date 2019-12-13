package pers.ZJ.StepWebDriver.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtil {

    /**
     * 正则判断
     * */
    public static boolean find(String s, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public static List<String> get(String s, String regex) {
        List<String> result = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

}