package com.zj0724.uiAuto;

import com.zj0724.uiAuto.webDriver.ChromeWebDriver;
import com.zj0724.uiAuto.webDriver.FirefoxWebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxWebDriver();


        webDriver.url("http://www.baidu.com");

        webDriver.close();

        webDriver = new ChromeWebDriver();

        webDriver.url("http://www.baidu.com");

        webDriver.close();
    }

}
