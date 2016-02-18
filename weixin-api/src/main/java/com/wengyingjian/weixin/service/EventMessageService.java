package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.SubscribeType;
import com.wengyingjian.weixin.common.model.WeixinResponseTextMessage;
import com.wengyingjian.weixin.common.model.WeixinSubscribeEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 事件:关注,取消关注事件处理业务content
 * Created by wengyingjian on 16/2/18.
 */
@Service
public class EventMessageService {

    Logger logger = LoggerFactory.getLogger(EventMessageService.class);

    @Value("${weixin.subscribe.welcome}")
    private String welcome;

    /**
     * 处理事件
     *
     * @return
     */
    public String handleMessage(WeixinSubscribeEventMessage subscribeEventMessage) {
        String subscribeType = subscribeEventMessage.getEvent();
        String response = "";
        if (SubscribeType.SUBSCRIBE.getType().equals(subscribeType)) {
            response = replySubscribeMessage(subscribeEventMessage);
        } else if (SubscribeType.SUBSCRIBE.getType().equals(subscribeType)) {
            response = replyUnsubscribeMessage(subscribeEventMessage);
        }

        WeixinResponseTextMessage toTextMessage = new WeixinResponseTextMessage();
        toTextMessage.wrapper(subscribeEventMessage);
        toTextMessage.setContent(response);
        return XmlUtil.toXml(toTextMessage);
    }

    private String replyUnsubscribeMessage(WeixinSubscribeEventMessage subscribeEventMessage) {
        logger.info("用户取消订阅:{}", JsonUtil.getJsonFromObject(subscribeEventMessage));
        return "";
    }

    private String replySubscribeMessage(WeixinSubscribeEventMessage subscribeEventMessage) {
        return welcome;
    }
}
