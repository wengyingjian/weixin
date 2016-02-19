package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestDefaultMessage;

/**
 * Created by wengyingjian on 16/2/17.
 */
@XStreamAlias("xml")
public class WeixinRequstTextMessage extends WeixinRequestDefaultMessage{
    @XStreamAlias("Content")
    private String content;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
