package com.zj0724.uiAuto.test;

import com.zj0724.uiAuto.WebDriver;
import com.zj0724.uiAuto.WebElement;
import com.zj0724.uiAuto.webDriver.ChromeWebDriver;

public class Test1 {

    public static void main(String[] args) {

        String path  = "E:\\ZJ\\chromeDriver\\83\\chromedriver.exe";

        WebDriver webDriver = new ChromeWebDriver(path, false);

        webDriver.url("file:///C:/Users/ZJ/Desktop/%E4%B8%8B%E8%BD%BD/%E6%96%B0%E5%BB%BA%E6%96%87%E4%BB%B6%E5%A4%B9/index.html");

        WebElement webElement = webDriver.findElementByXpath("/html/body/button");

        webDriver.await(6000);

        webElement.click();

    }

}
