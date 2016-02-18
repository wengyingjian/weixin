package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.enums.MessageType;


/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class ToTextMessage extends ToGeneralMessage {

    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Content")
    private String content;

    @Override
    public void wrapper(FromGeneralMessage fromGeneralMessage) {
        super.wrapper(fromGeneralMessage);
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