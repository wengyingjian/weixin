package com.wengyingjian.weixin.common.model.generic;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wengyingjian on 16/2/17.
 */
public class WeixinRequestEventMessage extends WeixinRequestMessage {

    @XStreamAlias("Event")
    private String event;
    @XStreamAlias("EventKey")
    private String eventKey;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
