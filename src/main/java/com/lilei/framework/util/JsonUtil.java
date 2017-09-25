package com.lilei.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON工具类
 * Created by Administrator on 2017/9/26.
 */
public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将POJO转成JSON
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("POJO对象转换成JSON对象失败",e);
            throw new RuntimeException(e);
        }
        return json;
    }
    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
//            pojo = OBJECT_MAPPER.readValue(json,type);
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (Exception e) {
            LOGGER.error("JSON转换成POJO对象失败",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
