package com.lilei.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 * Created by Administrator on 2017/9/26.
 */
public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 从输入流中获取字符串
     * @param is
     * @return
     */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader  reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            LOGGER.error("获取字符串失败",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
