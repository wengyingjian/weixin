package com.wengyingjian.weixin.common.enums;

/**
 * 消息类型
 * Created by wengyingjian on 16/2/17.
 */
public enum MessageType {
    TEXT("text", "文本"),
    IMAGE("image", "图片"),
    VOICE("voice", "声音"),
    VIDEO("video", "视频"),
    SHORT_VIDEO("shortvideo", "小视频"),
    LOCATION("location", "地址"),
    LINK("link", "链接");

    private String type;
    private String desc;

    private MessageType(String type, String desc) {
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
