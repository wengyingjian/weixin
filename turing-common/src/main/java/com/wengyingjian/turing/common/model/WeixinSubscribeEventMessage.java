package com.wengyingjian.turing.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.turing.common.model.generic.WeixinGeneralMessage;

/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class WeixinSubscribeEventMessage extends WeixinGeneralMessage {

    @XStreamAlias("Event")
    private String event;
    @XStreamAlias("EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
