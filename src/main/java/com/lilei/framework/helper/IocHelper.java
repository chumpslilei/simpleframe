package com.lilei.framework.helper;

import com.lilei.framework.annotation.Inject;
import com.lilei.framework.util.ArrayUtil;
import com.lilei.framework.util.CollectionUtil;
import com.lilei.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * @author lilei
 * Created by Administrator on 2017/9/21.
 */
public final class IocHelper
{
    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                Class<?> cls = beanEntry.getKey();//获取bean的映射
                Object beanInstance = beanEntry.getValue();//获取实例
                //获取类的成员变量
                Field[] beanFields = cls.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)){
                    for (Field beanField:beanFields){
                        //判断当前Bean Feild是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFeildClass = beanField.getType();
                            Object beanFeildInstance = beanMap.get(beanFeildClass);//获取bean对象实例
                            if (beanFeildInstance != null){
                                //通过反射初始化BeanFeild的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFeildInstance);
                            }
                        }


                    }
                }
            }
        }



    }
}
