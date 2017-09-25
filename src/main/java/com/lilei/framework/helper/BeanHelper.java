package com.lilei.framework.helper;

import com.lilei.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  Bean助手类
 *  @author lilei
 * Created by Administrator on 2017/8/8.
 */
public final class BeanHelper {
    /**
     * 用于存放Bean类和实例的映射关系
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>,Object>();
    static{
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass:beanClassSet){
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }

    /**
     * 获取bean映射
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取bean实例对象
     * @param cls 类名
     * @param <T>
     * @return
     */
    public static  <T> T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean class");
        }
        return (T) BEAN_MAP.get(cls);
    }
}
