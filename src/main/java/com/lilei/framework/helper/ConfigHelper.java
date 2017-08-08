package com.lilei.framework.helper;

import com.lilei.framework.ConfigConstent;
import com.lilei.framework.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by Administrator on 2017/8/5.
 * @author lilei
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstent.CONFIG_FILE);

    /**
     * 获取jdbc驱动
     * @return
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.JDBC_DRIVER);
    }
    /**
     * 获取jdbc的URL
     * @return
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.JDBC_URL);
    }
    /**
     * 获取jdbc用户名
     * @return
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.JDBC_USERNAME);
    }
    /**
     * 获取jdbc密码
     * @return
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.JDBC_PASSWORD);
    }
    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackge(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.APP_BASE_PACKGE);
    }
    /**
     * 获取应用jsp路径
     * @return
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.APP_JSP_PATH,"/WEB-INF/view/");
    }
    /**
     * 获取应用静态资源路径
     * @return
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstent.ASSET_PATH,"/asset/");
    }
}
