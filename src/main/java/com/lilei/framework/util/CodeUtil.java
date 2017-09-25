package com.lilei.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 * @author lilei
 * Created by Administrator on 2017/9/26.
 */
public final class CodeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeUtil.class);

    /**
     * 将URL编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("将URL编码失败",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将URL解码
     * @param source
     * @return
     */
    public static String decodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("URL解码失败",e);
            throw new RuntimeException();
        }
        return target;
    }

}
