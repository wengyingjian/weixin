package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/19.
 */
public enum WeixinRequestEventMessageType {

    SUBSCRIBE("subscribe", "订阅"),
    UN_SUBSCRIBE("unsubscribe", "取消订阅"),
    SCAN("SCAN", "扫描二维码"),
    LOCATION("LOCATION", "上报地理位置"),
    CLICK("CLICK", "点击菜单拉取消息"),
    VIEW("VIEW", "点击菜单跳转链接");

    private String type;
    private String desc;

    WeixinRequestEventMessageType(String type, String desc) {
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
