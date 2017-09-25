package com.lilei;

import com.lilei.framework.helper.ClassHelper;
import com.lilei.framework.util.ClassUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Set<Class<?>> classSet = ClassUtil.getClassSet("com.lilei");
        Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
        for (Class clazz:classSet
             ) {
            System.out.println(clazz);
        }
    }
}
