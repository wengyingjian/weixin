package com.wengyingjian.weixin.common.model.generic;

/**
 * 回复消息的父类
 * Created by wengyingjian on 16/2/18.
 */
public class WeixinResponseMessage extends WeixinGeneralMessage {

    public void wrapper(WeixinRequestMessage requestMessage) {
        this.setCreateTime(requestMessage.getCreateTime());
        this.setToUserName(requestMessage.getFromUserName());
        this.setFromUserName(requestMessage.getToUserName());
    }

}
