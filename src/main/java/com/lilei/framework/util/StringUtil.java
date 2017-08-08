package com.lilei.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/8/5.
 * @author lilei
 */
public final class StringUtil {
    /**
     * 判断空字符串
     * @param strValue
     * @return
     */
    public static boolean isEmpty(String strValue) {
        if (strValue != null){
            strValue = strValue.trim();
        }
        return StringUtils.isEmpty(strValue);
    }

    /**
     * 判断非空
     * @param strValue
     * @return
     */
    public static boolean isNotEmpty(String strValue) {
        return !isEmpty(strValue);
    }
}
