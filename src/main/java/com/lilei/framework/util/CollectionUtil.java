package com.lilei.framework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 * Created by Administrator on 2017/8/5.
 * @author lilei
 */
public final class CollectionUtil {
    /**
     * 判断collection是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断collection是否非空
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection){
        return CollectionUtil.isEmpty(collection);
    }
    /**
     * 判断map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?,?> map){
        return MapUtils.isEmpty(map);
    }

    /**
     * 判断map是否非空
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?,?> map){
        return CollectionUtil.isEmpty(map);
    }
}
