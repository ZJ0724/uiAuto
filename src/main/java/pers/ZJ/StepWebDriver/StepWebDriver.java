package pers.ZJ.StepWebDriver;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pers.ZJ.StepWebDriver.config.CheckInfoConfig;
import pers.ZJ.StepWebDriver.exception.BugException;
import pers.ZJ.StepWebDriver.exception.StepException;
import pers.ZJ.StepWebDriver.exception.WebDriverException;
import pers.ZJ.StepWebDriver.exception.WebElementException;
import pers.ZJ.StepWebDriver.util.RegularUtil;
import pers.ZJ.StepWebDriver.util.SeleniumUtil;
import pers.ZJ.StepWebDriver.util.StepUtil;
import java.io.File;
import java.util.List;
import java.util.Set;

public class StepWebDriver {

    private WebDriver webDriver;

    public StepWebDriver(File webdriverFile) {
        this(webdriverFile,false);
    }

    public StepWebDriver(File webdriverFile, boolean headless) {
        try {
            webDriver = SeleniumUtil.getChromeDriver(webdriverFile, headless);
        }catch (org.openqa.selenium.WebDriverException e) {
            throw new WebDriverException("驱动异常");
        }
    }

    /**
     * 校验step
     * */
    public static boolean check(String step){
        //控制长度
        if (step == null || step.length() < 6) {
            return false;
        }

        // 匹配浏览器操作
        for (String browserAction: CheckInfoConfig.BROWSER_ACTIONS) {
            if(RegularUtil.find(step,browserAction)){
                return true;
            }
        }

        // 校验元素操作
        if (!RegularUtil.find(step, CheckInfoConfig.ELEMENT_ACTION)) {
            return false;
        }

        //校验元素
        step=RegularUtil.get(step,"^\\$\\(\"(.*?)\"\\)").get(0);
        int a = step.indexOf("[");
        int b = step.indexOf("]");
        // 只有 “[” 或者 “]” ，并且 “]” 比 “[” 先出现，并且 “[” 开头
        if ((a == -1 && b != -1) || (a != -1 && b == -1) || (a>b) || (a == 0)) {
            return false;
        }
        // 没有[]
        if (a == -1 && b == -1) {
            return true;
        }
        // 去掉标签名
        step=step.substring(a);
        while (true) {
            if (!step.substring(0,1).equals("[")) {
                return false;
            }
            int c = step.indexOf("]");
            String attribute = step.substring(1,c);
            if (!attribute.contains("=") || attribute.contains("[") || attribute.contains("]")) {
                return false;
            }
            step=step.substring(c+1);

            // 截取完
            if (step.equals("")) {
                return true;
            }
        }
    }

    /**
     * 执行
     * */
    public void execute(String step){
        //检查step语法
        if(!check(step)){
            throw new StepException(step+"语法错误");
        }

        //执行浏览器操作
        String type = step.substring(0,3);
        //等待
        if (type.equals("wai")) {
            int time = Integer.parseInt(RegularUtil.get(step, "wait\\((.*?)\\)").get(0));
            try {
                Thread.sleep(time);
            }catch (InterruptedException e){
                throw new BugException(e.getMessage());
            }
            return;
        }

        //打开网址
        if (type.equals("url")) {
            String url = RegularUtil.get(step, "url\\(\"(.*?)\"\\)").get(0);
            try {
                SeleniumUtil.openUrl(webDriver,url);
            }catch (InvalidArgumentException e) {
                throw new WebElementException(step+"地址格式错误");
            }
            return;
        }

        //switchTo
        if (type.equals("swi")) {
            //等待2秒
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new BugException(e.getMessage());
            }
            Set<String> windowNameList = webDriver.getWindowHandles();
            String windowName = RegularUtil.get(step, "switchTo\\(\"(.*?)\"\\)").get(0);
            for (String s : windowNameList) {
                if (webDriver.switchTo().window(s).getTitle().equals(windowName)) {
                    webDriver = webDriver.switchTo().window(s);
                    break;
                }
            }
            return;
        }

        //获取xpath和action
        String xpath , action , actionType = null;
        List<String> list = StepUtil.getXpathAndAction(step);
        xpath = list.get(0);
        action = list.get(1);
        actionType = action.substring(0,5);

        //display()
        if (actionType.equals("displ")) {
            int start = 0;
            int timeout = Integer.parseInt(RegularUtil.get(action,"display\\((.*?)\\)").get(0));
            while (start < timeout) {
                try {
                    SeleniumUtil.getWebElement(webDriver,xpath);
                    return;
                }catch (NoSuchElementException e) {
                    start = start + 10000;
                }
            }
            throw new WebElementException(step+"元素未找到");
        }

        //获取元素
        WebElement webElement = null;
        try {
            webElement = SeleniumUtil.getWebElement(webDriver,xpath);
        }catch (NoSuchElementException e) {
            throw new WebElementException(step+"元素未找到");
        }

        //click()
        if (actionType.equals("click")) {
            webElement.click();
            return;
        }

        //sendKey()
        if (actionType.equals("sendK")) {
            //占位符
            if (action.substring(action.length()-3).equals("(?)")) {
                throw new StepException(step+"未输入参数");
            }
            String value = RegularUtil.get(action,"sendKey\\(\"(.*?)\"\\)").get(0);
            webElement.sendKeys(value);
            return;
        }

        //clear()
        if (actionType.equals("clear")) {
            webElement.clear();
        }
    }

    /**
     * 关闭驱动
     * */
    public void close(){
        SeleniumUtil.closeWebDriver(webDriver);
    }

    /**
     * 执行，通过占位符传参
     * */
    public void execute(String step, String value){
        int length = step.length();
        if (step.substring(length-10).equals("sendKey(?)")) {
            step = step.substring(0,length-2) + "\"" + value + "\")";
        }
        System.out.println(step);
        execute(step);
    }

}