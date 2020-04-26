package com.zj0724.uiAuto.constant;

import com.zj0724.uiAuto.config.ProjectConfig;
import java.io.File;

public enum WebDriver {

    WINDOWS_CHROME_WEB_DRIVER(new File(ProjectConfig.CONFIG_PATH, "chromeWebDriver/chromedriver.exe"),
            "/chromeWebDriver/windows/chromedriver.exe"),
    LINUX_CHROME_WEB_DRIVER(new File(ProjectConfig.CONFIG_PATH, "chromeWebDriver/chromedriver"),
            "/chromeWebDriver/linux/chromedriver"),

    WINDOWS_FIREFOX_WEB_DRIVER(new File(ProjectConfig.CONFIG_PATH, "firefoxWebDriver/geckodriver.exe"),
            "/firefoxWebDriver/windows/geckodriver.exe"),
    LINUX_FIREFOX_WEB_DRIVER(new File(ProjectConfig.CONFIG_PATH, "firefoxWebDriver/geckodriver"),
            "/firefoxWebDriver/linux/geckodriver");

    private final File webDriverFile;

    private final String webDriverResource;

    WebDriver(File webDriverFile, String webDriverResource) {
        this.webDriverFile = webDriverFile;
        this.webDriverResource = webDriverResource;
    }

    public File getWebDriverFile() {
        return this.webDriverFile;
    }

    public String getWebDriverResource() {
        return this.webDriverResource;
    }

}
