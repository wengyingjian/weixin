package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 接收到消息的父类
 *
 * Created by wengyingjian on 16/2/18.
 */
public class FromGeneralMessage extends GeneralMessage {

    @XStreamAlias("MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
