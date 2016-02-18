package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.MessageType;
import com.wengyingjian.weixin.common.model.FromTextMessage;
import com.wengyingjian.weixin.common.model.ToGeneralMessage;
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
        //1.根据接收到的消息来决定消息的返回类型是文本还是图片
        MessageType returnType = dispatchReplyType(fromTextMessage);
        if (returnType == null) {
            return "";
        }
        //2.为不同的回复消息类型分配不同的解决方案,最终得到ToGeneralMessage对象
        ToGeneralMessage replyMessage = null;
        if (returnType == MessageType.TEXT) {
            replyMessage = replyTextMessage(fromTextMessage);
        } else if (returnType == MessageType.IMAGE) {
            replyMessage = replyImageMessage(fromTextMessage);
        }
        if (replyMessage == null) {
            return "";
        }
        //3.将java对象转化为xml格式返回
        return XmlUtil.toXml(replyMessage);
    }

    private ToGeneralMessage replyImageMessage(FromTextMessage fromTextMessage) {
        return null;
    }

    /**
     * 返回回复文本消息对象
     *
     * @param fromTextMessage
     * @return
     */
    private ToTextMessage replyTextMessage(FromTextMessage fromTextMessage) {
        ToTextMessage toTextMessage = new ToTextMessage();
        toTextMessage.wrapper(fromTextMessage);
        toTextMessage.setContent(doReplyTextMessage(fromTextMessage));
        return toTextMessage;
    }

    /**
     * 文本消息回复内容的逻辑实现
     *
     * @param fromTextMessage
     * @return
     */
    private String doReplyTextMessage(FromTextMessage fromTextMessage) {
        return fromTextMessage.getContent() + "!!!";
    }

    private MessageType dispatchReplyType(FromTextMessage fromTextMessage) {
        //TODO:根据消息内容判断出返回消息的类型
        String content = fromTextMessage.getContent();
        if (true) {
            return MessageType.TEXT;
        }
        return MessageType.TEXT;
    }

}
