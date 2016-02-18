package com.wengyingjian.turing.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.turing.common.model.generic.WeixinRequestGeneralMessage;

/**
 * Created by wengyingjian on 16/2/17.
 */
@XStreamAlias("xml")
public class WeixinRequstEventMessage extends WeixinRequestGeneralMessage {
    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
