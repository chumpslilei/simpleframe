package com.lilei.framework.helper;

import com.lilei.framework.util.CastUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *请求参数对象
 * @author lilei
 * Created by Administrator on 2017/9/25.
 */
public class Param {
    private Map<String,Object> parmMap = new HashMap<String,Object>();

    public Param(Map<String, Object> parmMap) {
        this.parmMap = parmMap;
    }

    /**
     * 根据参数名获取long类型的值
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(parmMap.get(name));
    }

    /**
     * 获取所有参数
     * @return
     */
    public Map<String,Object> getMap(){
        return parmMap;
    }

}
