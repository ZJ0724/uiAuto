package com.zj0724.uiAuto.test;

import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) {

        String path  = "E:\\ZJ\\chromeDriver\\81\\chromedriver.exe";

        WebDriver webDriver = new ChromeWebDriver(path, false);

        webDriver.url("https://www.baidu.com");

        System.out.println(1);

        webDriver.close();

    }

}
