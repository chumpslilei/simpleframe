package com.lilei.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * Created by Administrator on 2017/9/21.
 */
public final class ArrayUtil {
    /**
     * 判断一个数组不为空
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array){
        return !isEmpty(array);
    }

    /**
     * 判断一个数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
