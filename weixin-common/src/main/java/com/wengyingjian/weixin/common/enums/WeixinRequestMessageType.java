package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/19.
 */
public enum WeixinRequestMessageType {
    DEFAULT_TEXT("text", "文本消息"),
    DEFAULT_IMAGE("image", "图片消息"),
    DEFAULT_VOICE("voice", "声音消息"),
    DEFAULT_VIDEO("video", "视频消息"),
    DEFAULT_SHORT_VIDEO("shortvideo", "小视频消息"),
    DEFAULT_LOCATION("location", "地址消息"),
    DEFAULT_LINK("link", "链接消息"),

    EVENT("event", "事件消息");

    private String type;
    private String desc;

    WeixinRequestMessageType(String type, String desc) {
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

