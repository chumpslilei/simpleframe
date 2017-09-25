package com.lilei.framework.helper;

/**
 * 返回数据对象
 * @author lilei
 * Created by Administrator on 2017/9/25.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model){
        this.model = model;
    }

    public Object getModel(){
        return model;
    }
}
