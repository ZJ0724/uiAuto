package com.zj0724.uiAuto.config;

import com.zj0724.uiAuto.constant.SystemType;

public class ProjectConfig {

    /**
     * 配置存放目录
     * */
    public static final String CONFIG_PATH = System.getProperty("user.home") + "/.uiAuto";

    /**
     * 系统类型
     * */
    public static final SystemType SYSTEM_TYPE = System.getProperty("os.name").contains("Windows") ? SystemType.WINDOWS : (System.getProperty("os.name").contains("Linux") ? SystemType.LINUX : null);

}
