package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.model.FromTextMessage;
import com.wengyingjian.weixin.common.model.ToTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by wengyingjian on 16/2/17.
 */
@Service
public class TextMessageService {

    private Logger logger = LoggerFactory.getLogger(TextMessageService.class);

    /**
     * 处理文本信息
     *
     * @param fromTextMessage
     * @return
     */
    public String handleMessage(FromTextMessage fromTextMessage) {
        logger.info("handling message :[{}]...", JsonUtil.getJsonFromObject(fromTextMessage));
        ToTextMessage toTextMessage = doHaneldMessage(fromTextMessage);
        return XmlUtil.toXml(toTextMessage);
    }

    private ToTextMessage doHaneldMessage(FromTextMessage fromTextMessage) {
        ToTextMessage toTextMessage = new ToTextMessage();
        toTextMessage.setCreateTime(fromTextMessage.getCreateTime());
        toTextMessage.setFromUserName(fromTextMessage.getToUserName());
        toTextMessage.setToUserName(fromTextMessage.getFromUserName());
        toTextMessage.setMsgType(fromTextMessage.getMsgType());
        toTextMessage.setContent("content!!!");
        return toTextMessage;
    }
}
