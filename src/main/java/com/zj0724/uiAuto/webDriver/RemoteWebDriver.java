package com.zj0724.uiAuto.webDriver;

import com.zj0724.uiAuto.DriverType;
import com.zj0724.uiAuto.exception.WebDriverException;
import org.openqa.selenium.WebDriver;
import java.net.URL;

/**
 * RemoteWebDriver
 *
 * @author ZJ
 * */
public final class RemoteWebDriver extends AbstractWebDriver {

    public RemoteWebDriver(String url, DriverType driverType, boolean isShow) {
        super(getWebDriver(url, driverType, isShow));
    }

    public RemoteWebDriver(String url, DriverType driverType) {
        this(url, driverType, false);
    }

    private static WebDriver getWebDriver(String url, DriverType driverType, boolean isShow) {
        try {
            return new org.openqa.selenium.remote.RemoteWebDriver(new URL(url), driverType.getMutableCapabilities(isShow));
        } catch (Exception e) {
            throw new WebDriverException(e.getMessage());
        }
    }

}