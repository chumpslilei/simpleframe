package com.lilei.framework.helper;

import com.lilei.framework.annotation.Action;
import com.lilei.framework.annotation.Inject;
import com.lilei.framework.bean.Handler;
import com.lilei.framework.bean.Request;
import com.lilei.framework.util.ArrayUtil;
import com.lilei.framework.util.CollectionUtil;
import com.lilei.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * @author lilei
 * Created by Administrator on 2017/9/22.
 */
public final class ControllerHelper {
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();
    static {
       Set<Class<?>> controllerClassSet =  ClassHelper.getControllerClassSet();//获取所有带@Controller注解
       if (CollectionUtil.isNotEmpty(controllerClassSet)){//判断是否为null
           for (Class<?> controllerClass:controllerClassSet){
                Method[] methods = controllerClass.getDeclaredMethods();//获取类中所有方法
               if (ArrayUtil.isNotEmpty(methods)){
                   for (Method method:methods){
                       if (method.isAnnotationPresent(Action.class)){//判断方法是否用@Action注解
                           Action action = method.getAnnotation(Action.class);//从action注解中获取Url映射规则
                           String mapping = action.value();//获取url
                           if (mapping.matches("\\w+:\\w*")){
                               String[] array = mapping.split(":");
                               if (ArrayUtil.isNotEmpty(array) && array.length == 2){
                                   String requestMthod = array[0];
                                   String requestPath = array[1];
                                   Request request = new Request(requestMthod,requestPath);
                                   Handler handler = new Handler(controllerClass,method);
                                   ACTION_MAP.put(request,handler);//初始化集合
                               }
                           }
                       }
                   }
               }
           }
       }
    }

    /**
     * 获取一个Handler对象
     * @param requestMethod 方法
     * @param requestPath 路径
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
