package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/20.
 */
public enum CommonStatus {
    EFFECTIVE(0, "有效"),
    UN_EFFECTIVE(1, "失效");

    private Integer code;
    private String desc;

    CommonStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
