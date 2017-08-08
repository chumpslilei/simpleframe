package com.lilei.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * Created by Administrator on 2017/8/5.
 * @author lilei
 */
public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName 文件名
     * @return
     */
    public static final Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException(fileName+"文件找不到");
            }
            props = new Properties();
            props.load(is);

        } catch (Exception e) {
            LOGGER.error("加载文件失败",e);
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("关闭文件流失败",e);
                }

            }
        }
        return props;
    }
    /**
     * 获取字符属性值(默认值为空)
     * @param prop
     * @param key
     * @return
     */
    public static String getString(Properties prop,String key){
        return getString(prop,key,"");
    }

    /**
     * 获取字符属性值(可指定默认值)
     * @param prop
     * @param key
     * @param defaultvalue
     * @return
     */
    public static String getString(Properties prop,String key,String defaultvalue){
        String value = defaultvalue;
        if (prop.containsKey(key)){
            value = prop.getProperty(key);
        }
        return value;
    }
    /**
     * 获取数值属性值(默认值为空)
     * @param prop
     * @param key
     * @return
     */
    public static int getInt(Properties prop,String key){
        return getInt(prop,key,0);
    }

    /**
     * 获取数值属性值(可指定默认值)
     * @param prop
     * @param key
     * @param defaultvalue
     * @return
     */
    public static int getInt(Properties prop,String key,int defaultvalue){
        int value = defaultvalue;
        if (prop.containsKey(key)){
            value = CastUtil.castInt(prop.getProperty(key));
        }
        return value;
    }
    /**
     * 获取boolean属性值(可指定默认值)
     * @param prop
     * @param key
     * @return
     */
    public static Boolean getBoolean(Properties prop,String key){
        return getBoolean(prop,key,false);
    }

    /**
     * 获取boolean属性值(可指定默认值)
     * @param prop
     * @param key
     * @param defaultvalue
     * @return
     */
    public static Boolean getBoolean(Properties prop,String key,boolean defaultvalue){
        boolean value = defaultvalue;
        if (prop.containsKey(key)){
            value = CastUtil.castBoolean(prop.getProperty(key));
        }
        return value;
    }
}
