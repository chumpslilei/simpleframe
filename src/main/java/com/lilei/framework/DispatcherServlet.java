package com.lilei.framework;

import com.lilei.framework.bean.Handler;
import com.lilei.framework.helper.BeanHelper;
import com.lilei.framework.helper.ConfigHelper;
import com.lilei.framework.helper.ControllerHelper;
import com.lilei.framework.helper.HelperLoader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求转发器
 * @author lilei
 * Created by Administrator on 2017/9/25.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        super.init();
        HelperLoader.init();//初始化相关的Helper类
        ServletContext servletContext  = servletConfig.getServletContext();//获取servletContext对象
        ServletRegistration jspServerlet = servletContext.getServletRegistration("jsp");//注册处理jsp的servlet
        jspServerlet.addMapping(ConfigHelper.getAppJspPath()+"*");
        //注册处理静态资源默认的servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        //获取请求方法和请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //获取Action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if (handler != null){
            //获取Controller类及Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象对象
            Map<String,Object> paramMap = new HashMap<String,Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
        }
    }
}
