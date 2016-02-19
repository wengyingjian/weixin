package com.wengyingjian.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 微信请求xml字符串解析器
 * Created by wengyingjian on 16/2/19.
 */
@Service
public class WeixinMessageResolver {

    private static Logger logger = LoggerFactory.getLogger(WeixinMessageResolver.class);
    private static final String TYPE_PATTERN = "/xml/MsgType";

    /**
     * 从xml中解析出type属性
     *
     * @param messageContent
     * @return
     */
    public static String resolveRequestMessageType(String messageContent) {
        try {
            return XPathUtil.parse(messageContent, TYPE_PATTERN);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("parse error for message : [{}] \n reason : [{}]", messageContent, e.getMessage());
            return null;
        }
    }
}
