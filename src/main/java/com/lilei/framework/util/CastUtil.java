package com.lilei.framework.util;

/**类型转换工具类
 * Created by Administrator on 2017/8/5.
 * @author lilei
 */
public final class CastUtil {
    /**
     * 转成String类型的方法
     * @param obj
     * @return
     */
    public static String castString(Object obj){
        return castString(obj,"");
    }

    /**
     * 转成string，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj,String defaultValue) {
        return obj != null?String.valueOf(obj):defaultValue;
    }

    /**
     * 转成int类型
     * @param obj
     * @return
     */
    public static int castInt(Object obj) {
        return castInt(obj,0);
    }

    /**
     * 转成double类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj,int defaultValue) {
        int intValue = defaultValue;
        if (obj != null){
            String strValue = String.valueOf(obj);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }


    /**
     * 转成double类型
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return castDouble(obj,0);
    }

    /**
     * 转成double类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj,double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null){
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    doubleValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转成long类型
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj,0);
    }

    /**
     * 转成long类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj,long defaultValue) {
        long longValue = defaultValue;
        if (obj != null){
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    public static boolean castBoolean(Object obj) {
        return castBoolean(obj,false);
    }
    /**
     * 转成boolean类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj,boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null){
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)){
                try {
                    booleanValue = Boolean.parseBoolean(strValue);
                } catch (NumberFormatException e) {
                    booleanValue = defaultValue;
                }
            }
        }
        return booleanValue;
    }
}
