package com.wengyingjian.weixin.common.model.generic;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.model.generic.GeneralMessage;

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
