package com.wengyingjian.weixin.common.model.generic;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wengyingjian on 16/2/19.
 */
public class WeixinRequestDefaultMessage extends WeixinRequestMessage {

    @XStreamAlias("MsgId")
    private String msgId;


}
