package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.turing.common.enums.MessageType;
import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.model.WeixinRequstTextMessage;
import com.wengyingjian.turing.common.model.WeixinResponseImageMessage;
import com.wengyingjian.turing.common.model.generic.WeixinResponseGeneralMessage;
import com.wengyingjian.turing.common.model.WeixinResponseTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文本消息回复
 * Created by wengyingjian on 16/2/17.
 */
@Service
public class TextMessageService {

    private Logger logger = LoggerFactory.getLogger(TextMessageService.class);

    @Autowired
    private TuringMessageService turingMessageService;
    @Autowired
    private OrangeService orangeService;

    /**
     * 处理文本信息
     *
     * @param fromTextMessage
     * @return
     */
    public String handleMessage(WeixinRequstTextMessage fromTextMessage) {
        logger.info("handling message :[{}]...", JsonUtil.getJsonFromObject(fromTextMessage));
        //1.根据接收到的消息来决定消息的返回类型是文本还是图片
        MessageType returnType = dispatchReplyType(fromTextMessage);
        if (returnType == null) {
            return "";
        }
        //2.为不同的回复消息类型分配不同的解决方案,最终得到ToGeneralMessage对象
        WeixinResponseGeneralMessage replyMessage = null;
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

    /**
     * 文本消息回复内容的逻辑实现
     *
     * @param fromTextMessage
     * @return
     */
    private String doReplyTextMessage(WeixinRequstTextMessage fromTextMessage) {
        String content = fromTextMessage.getContent();

        //orange相关过滤
        if (orangeService.filter(content)) {
            return orangeService.request(content);
        }

        //使用turing回复
        TuringRequestMessage turingRequestMessage = new TuringRequestMessage();
        turingRequestMessage.setInfo(content);
        turingRequestMessage.setUserid(fromTextMessage.getFromUserName());
        return turingMessageService.chat(turingRequestMessage);
    }

    private boolean filterMessage(WeixinRequstTextMessage fromTextMessage) {
        return false;
    }

    /**
     * @param fromTextMessage
     * @return 图片的url地址
     */
    private String doReplyImageMessage(WeixinRequstTextMessage fromTextMessage) {
        return "订阅.png";
    }

    private WeixinResponseGeneralMessage replyImageMessage(WeixinRequstTextMessage fromTextMessage) {
        WeixinResponseImageMessage toImageMessage = new WeixinResponseImageMessage();
        toImageMessage.wrapper(fromTextMessage);
        WeixinResponseImageMessage.Image image = new WeixinResponseImageMessage.Image();
        image.setMediaId(doReplyImageMessage(fromTextMessage));
        toImageMessage.setImage(image);
        return toImageMessage;
    }


    /**
     * 返回回复文本消息对象
     *
     * @param fromTextMessage
     * @return
     */
    private WeixinResponseTextMessage replyTextMessage(WeixinRequstTextMessage fromTextMessage) {
        WeixinResponseTextMessage toTextMessage = new WeixinResponseTextMessage();
        toTextMessage.wrapper(fromTextMessage);
        String content = doReplyTextMessage(fromTextMessage);
        toTextMessage.setContent(content);
        return toTextMessage;
    }

    private MessageType dispatchReplyType(WeixinRequstTextMessage fromTextMessage) {
        //TODO:根据消息内容判断出返回消息的类型
        String content = fromTextMessage.getContent();
//        if ("图片".equals(content)) {
//            return MessageType.IMAGE;
//        }
        return MessageType.TEXT;
    }

}
