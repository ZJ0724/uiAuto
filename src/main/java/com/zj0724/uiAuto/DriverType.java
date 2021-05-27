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

    CHROME(() -> {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions().merge(desiredCapabilities);
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--no-sandbox");
        return chromeOptions;
    }),

    FIREBOX(() -> {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions().merge(desiredCapabilities);
        firefoxOptions.setHeadless(true);
        firefoxOptions.addArguments("--no-sandbox");
        return firefoxOptions;
    });

    private final MutableCapabilities mutableCapabilities;

    DriverType(Option option) {
        this.mutableCapabilities = option.getMutableCapabilities();
    }

    public MutableCapabilities getMutableCapabilities() {
        return mutableCapabilities;
    }

    private interface Option {

        MutableCapabilities getMutableCapabilities();

    }

}