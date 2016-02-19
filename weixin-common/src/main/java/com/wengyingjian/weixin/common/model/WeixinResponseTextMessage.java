package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.enums.WeixinRequestMessageType;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;


/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class WeixinResponseTextMessage extends WeixinResponseMessage {

    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Content")
    private String content;

    @Override
    public void wrapper(WeixinRequestMessage requestMessage) {
        super.wrapper(requestMessage);
        this.msgType = WeixinRequestMessageType.DEFAULT_TEXT.getType();
    }


    @Override
    public String getMsgType() {
        return msgType;
    }

    @Override
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}