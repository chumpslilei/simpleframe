package com.lilei.framework.helper;

import com.lilei.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * @author lilei
 * Created by Administrator on 2017/9/25.
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
