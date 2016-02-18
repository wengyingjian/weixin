package com.wengyingjian.turing.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.turing.common.enums.MessageType;
import com.wengyingjian.turing.common.model.generic.WeixinGeneralMessage;
import com.wengyingjian.turing.common.model.generic.WeixinResponseGeneralMessage;


/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class WeixinResponseTextMessage extends WeixinResponseGeneralMessage {

    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Content")
    private String content;

    @Override
    public void wrapper(WeixinGeneralMessage generalMessage) {
        super.wrapper(generalMessage);
        this.msgType = MessageType.TEXT.getType();
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