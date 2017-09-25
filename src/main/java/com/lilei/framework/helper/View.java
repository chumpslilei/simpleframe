package com.lilei.framework.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回视图对象
 * @author lilei
 * Created by Administrator on 2017/9/25.
 */
public class View {
    private String path;//视图路径
    private Map<String,Object> model;//返回模型数据

    public View(String path){
        this.path = path;
        model = new HashMap<String,Object>();
    }

    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath(){
        return path;
    }

    public Map<String,Object> getModel(){
        return model;
    }
}
