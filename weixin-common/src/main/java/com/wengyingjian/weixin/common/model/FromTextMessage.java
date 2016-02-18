package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.model.generic.FromGeneralMessage;

/**
 * Created by wengyingjian on 16/2/17.
 */
@XStreamAlias("xml")
public class FromTextMessage extends FromGeneralMessage {
    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
