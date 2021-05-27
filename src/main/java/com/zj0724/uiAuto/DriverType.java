package com.zj0724.uiAuto;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 驱动类型
 *
 * @author ZJ
 * */
public enum DriverType {

    CHROME(DesiredCapabilities.chrome()),

    FIREBOX(DesiredCapabilities.firefox());

    private final DesiredCapabilities desiredCapabilities;

    DriverType(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

}