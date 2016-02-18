package com.wengyingjian.weixin.common.model.generic;

/**
 * 回复消息的父类
 * Created by wengyingjian on 16/2/18.
 */
public class WeixinResponseGeneralMessage extends WeixinGeneralMessage {

    public void wrapper(WeixinGeneralMessage generalMessage) {
        this.setCreateTime(generalMessage.getCreateTime());
        this.setToUserName(generalMessage.getFromUserName());
        this.setFromUserName(generalMessage.getToUserName());
    }

}
