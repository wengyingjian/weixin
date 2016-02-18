package com.wengyingjian.weixin.common.model.generic;

/**
 * 回复消息的父类
 * Created by wengyingjian on 16/2/18.
 */
public class WeixinResponseGeneralMessage extends WeixinGeneralMessage {

    public void wrapper(WeixinRequestGeneralMessage fromGeneralMessage) {
        this.setCreateTime(fromGeneralMessage.getCreateTime());
        this.setToUserName(fromGeneralMessage.getFromUserName());
        this.setFromUserName(fromGeneralMessage.getToUserName());
    }

}
