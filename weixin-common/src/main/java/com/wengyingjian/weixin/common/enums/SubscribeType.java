package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/18.
 */
public enum SubscribeType {

    SUBSCRIBE("subscribe", "订阅"),
    UN_SUBSCRIBE("unsubscribe", "取消订阅");

    private String type;
    private String desc;

    SubscribeType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
