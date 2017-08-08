package com.lilei.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * @author lilei
 * Created by Administrator on 2017/8/7.
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 获取类的实例
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
           LOGGER.error("创建实例失败",e);
           throw new RuntimeException();
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method,Object... args){
        Object result;
        try {
            method.setAccessible(true);//取消java语言访问检查
            result = method.invoke(obj,args);
        }  catch (Exception e) {
            LOGGER.error("invoke 方法失败",e);
            throw new RuntimeException();
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field, Object value){
        try {
           field.setAccessible(true);
           field.set(obj,value);
        }  catch (Exception e) {
            LOGGER.error("设置field方法失败",e);
            throw new RuntimeException();
        }
    }
}
