package com.lilei.framework.bean;

import java.lang.reflect.Method;

/**用于封装Action的信息
 * @author lilei
 * Created by Administrator on 2017/9/22.
 */
public class Handler {
    //用于存储Controller类
    private Class<?> controllerClass;
    private Method actionMethod;//action中的方法

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
