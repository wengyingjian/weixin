package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/19.
 */
public enum  UserStatus {

    SUBSCRIBE(0,"订阅"),
    UNSUBSCRIBE(1,"取消订阅");

    private Integer code;
    private String desc;

    UserStatus(Integer status, String desc) {
        this.code = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return code;
    }

    public void setStatus(Integer status) {
        this.code = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
