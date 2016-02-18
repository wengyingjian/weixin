package com.wengyingjian.turing.common.model.generic;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 接收到消息的父类
 *
 * Created by wengyingjian on 16/2/18.
 */
public class WeixinRequestGeneralMessage extends WeixinGeneralMessage {

    @XStreamAlias("MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
