package com.zj0724.uiAuto;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 驱动类型
 *
 * @author ZJ
 * */
public enum DriverType {

    CHROME((boolean isShow) -> {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions().merge(desiredCapabilities);
        if (isShow) {
            chromeOptions.setHeadless(true);
        }
        if (Storage.SYSTEM_OS == SystemOS.LINUX) {
            chromeOptions.addArguments("--no-sandbox");
        }
        return chromeOptions;
    }),

    FIREBOX((boolean isShow) -> {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions().merge(desiredCapabilities);
        if (isShow) {
            firefoxOptions.setHeadless(true);
        }
        if (Storage.SYSTEM_OS == SystemOS.LINUX) {
            firefoxOptions.addArguments("--no-sandbox");
        }
        return firefoxOptions;
    });

    private final Option option;

    DriverType(Option option) {
        this.option = option;
    }

    public MutableCapabilities getMutableCapabilities(boolean isShow) {
        return this.option.getMutableCapabilities(isShow);
    }

    private interface Option {

        MutableCapabilities getMutableCapabilities(boolean isShow);

    }

}