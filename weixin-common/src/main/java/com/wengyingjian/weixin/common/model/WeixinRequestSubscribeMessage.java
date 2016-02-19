package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestEventMessage;

/**
 * Created by wengyingjian on 16/2/19.
 */
@XStreamAlias("xml")
public class WeixinRequestSubscribeMessage extends WeixinRequestEventMessage {

    @XStreamAlias("Event")
    private String event;
    @XStreamAlias("EventKey")
    private String eventKey;

    @Override
    public String getEvent() {
        return event;
    }

    @Override
    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String getEventKey() {
        return eventKey;
    }

    @Override
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
