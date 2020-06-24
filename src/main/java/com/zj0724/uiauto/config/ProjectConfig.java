package com.zj0724.uiauto.config;

/**
 * 项目配置
 *
 * @author ZJ
 * */
public final class ProjectConfig {

    /** 系统类型 */
    public static final SystemOSConfig SYSTEM_TYPE = System.getProperty("os.name").contains("Windows") ? SystemOSConfig.WINDOWS : (System.getProperty("os.name").contains("Linux") ? SystemOSConfig.LINUX : null);

}